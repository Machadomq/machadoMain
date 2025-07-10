import { test, expect } from '@playwright/test';

test.describe('Sistema CRUD - Testes Funcionais', () => {
  let createdUserId = null;

  test.beforeEach(async ({ page }) => {
    // Navegar para a página principal
    await page.goto('/');
    
    // Aguardar a página carregar
    await page.waitForLoadState('networkidle');
    
    // Verificar se a página carregou corretamente
    await expect(page).toHaveTitle(/Sistema CRUD/);
    await expect(page.locator('h1')).toContainText('Sistema CRUD');
  });

  test('Deve carregar a página inicial corretamente', async ({ page }) => {
    // Verificar elementos principais da página
    await expect(page.locator('h1')).toContainText('Sistema CRUD - Gerenciamento de Usuários');
    await expect(page.locator('h2').first()).toContainText('Cadastrar Novo Usuário');
    await expect(page.locator('h2').last()).toContainText('Usuários Cadastrados');
    
    // Verificar formulário
    await expect(page.locator('#name')).toBeVisible();
    await expect(page.locator('#email')).toBeVisible();
    await expect(page.locator('#age')).toBeVisible();
    await expect(page.locator('#submitBtn')).toBeVisible();
  });

  test('Deve criar um novo usuário (POST)', async ({ page }) => {
    const timestamp = Date.now();
    const testUser = {
      name: 'João Teste',
      email: `joao.teste.${timestamp}@email.com`,
      age: '30'
    };

    // Preencher formulário
    await page.fill('#name', testUser.name);
    await page.fill('#email', testUser.email);
    await page.fill('#age', testUser.age);

    // Submeter formulário
    await page.click('#submitBtn');

    // Verificar mensagem de sucesso
    await expect(page.locator('.alert-success')).toContainText('Usuário criado com sucesso');

    // Verificar se o usuário apareceu na lista
    await page.waitForSelector('[data-testid^="user-card-"]', { timeout: 5000 });
    
    const userCards = page.locator('[data-testid^="user-card-"]');
    const userCard = userCards.filter({ hasText: testUser.name }).first();
    
    await expect(userCard).toContainText(testUser.name);
    await expect(userCard).toContainText(testUser.email);
    await expect(userCard).toContainText(testUser.age + ' anos');

    // Capturar ID do usuário criado para testes posteriores
    const cardId = await userCard.getAttribute('data-testid');
    createdUserId = cardId?.replace('user-card-', '');
  });

  test('Deve listar usuários existentes (GET)', async ({ page }) => {
    // Aguardar carregar a lista de usuários
    await page.waitForSelector('[data-testid^="user-card-"], .no-users', { timeout: 5000 });
    
    // Verificar se existe pelo menos um usuário ou mensagem de "nenhum usuário"
    const userCards = page.locator('[data-testid^="user-card-"]');
    const noUsersMessage = page.locator('.no-users');
    
    const userCount = await userCards.count();
    const hasNoUsersMessage = await noUsersMessage.isVisible();
    
    // Deve ter usuários OU mensagem de "nenhum usuário"
    expect(userCount > 0 || hasNoUsersMessage).toBeTruthy();
    
    if (userCount > 0) {
      // Verificar se o primeiro usuário tem os elementos esperados
      const firstUser = userCards.first();
      await expect(firstUser).toContainText('👤');
      await expect(firstUser).toContainText('📧');
      await expect(firstUser).toContainText('🎂');
      await expect(firstUser).toContainText('🆔');
      
      // Verificar botões de ação
      await expect(firstUser.locator('[data-testid^="edit-btn-"]')).toBeVisible();
      await expect(firstUser.locator('[data-testid^="delete-btn-"]')).toBeVisible();
    }
  });

  test('Deve editar um usuário existente (PUT)', async ({ page }) => {
    // Primeiro criar um usuário para editar
    const timestamp = Date.now();
    const originalUser = {
      name: 'Usuário Original',
      email: `original.${timestamp}@email.com`,
      age: '25'
    };

    // Criar usuário
    await page.fill('#name', originalUser.name);
    await page.fill('#email', originalUser.email);
    await page.fill('#age', originalUser.age);
    await page.click('#submitBtn');

    // Aguardar criação
    await expect(page.locator('.alert-success')).toContainText('Usuário criado com sucesso');
    await page.waitForSelector('[data-testid^="user-card-"]', { timeout: 5000 });

    // Encontrar o usuário criado e clicar em editar
    const userCard = page.locator('[data-testid^="user-card-"]').filter({ hasText: originalUser.name }).first();
    await userCard.locator('[data-testid^="edit-btn-"]').click();

    // Verificar se o formulário mudou para modo edição
    await expect(page.locator('#formTitle')).toContainText('Editar Usuário');
    await expect(page.locator('#submitBtn')).toContainText('Atualizar Usuário');
    await expect(page.locator('#cancelBtn')).toBeVisible();

    // Verificar se os dados foram preenchidos
    await expect(page.locator('#name')).toHaveValue(originalUser.name);
    await expect(page.locator('#email')).toHaveValue(originalUser.email);
    await expect(page.locator('#age')).toHaveValue(originalUser.age);

    // Alterar dados
    const updatedUser = {
      name: 'Usuário Editado',
      email: `editado.${timestamp}@email.com`,
      age: '35'
    };

    await page.fill('#name', updatedUser.name);
    await page.fill('#email', updatedUser.email);
    await page.fill('#age', updatedUser.age);

    // Submeter alterações
    await page.click('#submitBtn');

    // Verificar mensagem de sucesso
    await expect(page.locator('.alert-success')).toContainText('Usuário atualizado com sucesso');

    // Aguardar um pouco para a interface voltar ao normal
    await page.waitForTimeout(1000);

    // Verificar se o formulário voltou ao modo normal
    await expect(page.locator('#formTitle')).toContainText('Cadastrar Novo Usuário');
    await expect(page.locator('#submitBtn')).toContainText('Cadastrar Usuário');

    // Verificar se os dados foram atualizados na lista
    await page.waitForSelector('[data-testid^="user-card-"]', { timeout: 5000 });
    const updatedUserCard = page.locator('[data-testid^="user-card-"]').filter({ hasText: updatedUser.name }).first();
    
    await expect(updatedUserCard).toContainText(updatedUser.name);
    await expect(updatedUserCard).toContainText(updatedUser.email);
    await expect(updatedUserCard).toContainText(updatedUser.age + ' anos');
  });

  test('Deve deletar um usuário existente (DELETE)', async ({ page }) => {
    // Primeiro criar um usuário para deletar
    const timestamp = Date.now();
    const testUser = {
      name: 'Usuário Para Deletar',
      email: `deletar.${timestamp}@email.com`,
      age: '28'
    };

    // Criar usuário
    await page.fill('#name', testUser.name);
    await page.fill('#email', testUser.email);
    await page.fill('#age', testUser.age);
    await page.click('#submitBtn');

    // Aguardar criação
    await expect(page.locator('.alert-success')).toContainText('Usuário criado com sucesso');
    await page.waitForSelector('[data-testid^="user-card-"]', { timeout: 5000 });

    // Encontrar o usuário criado
    const userCard = page.locator('[data-testid^="user-card-"]').filter({ hasText: testUser.name }).first();
    await expect(userCard).toContainText(testUser.name);

    // Preparar para interceptar o diálogo de confirmação
    page.on('dialog', dialog => dialog.accept());

    // Clicar no botão de deletar
    await userCard.locator('[data-testid^="delete-btn-"]').click();

    // Verificar mensagem de sucesso
    await expect(page.locator('.alert-success')).toContainText('Usuário excluído com sucesso');

    // Verificar se o usuário foi removido da lista
    await page.waitForTimeout(1000); // Aguardar atualização da lista
    
    const deletedUserCard = page.locator('[data-testid^="user-card-"]').filter({ hasText: testUser.name });
    await expect(deletedUserCard).toHaveCount(0);
  });

  test('Deve validar campos obrigatórios', async ({ page }) => {
    // Tentar submeter formulário vazio
    await page.click('#submitBtn');

    // Verificar validação HTML5
    const nameField = page.locator('#name');
    const emailField = page.locator('#email');
    const ageField = page.locator('#age');

    // Verificar se os campos estão marcados como inválidos
    await expect(nameField).toHaveAttribute('required');
    await expect(emailField).toHaveAttribute('required');
    await expect(ageField).toHaveAttribute('required');
  });

  test('Deve cancelar edição corretamente', async ({ page }) => {
    // Primeiro criar um usuário
    const timestamp = Date.now();
    const testUser = {
      name: 'Usuário Teste Cancel',
      email: `cancel.${timestamp}@email.com`,
      age: '30'
    };

    await page.fill('#name', testUser.name);
    await page.fill('#email', testUser.email);
    await page.fill('#age', testUser.age);
    await page.click('#submitBtn');

    // Aguardar criação
    await expect(page.locator('.alert-success')).toContainText('Usuário criado com sucesso');
    await page.waitForSelector('[data-testid^="user-card-"]', { timeout: 5000 });

    // Clicar em editar
    const userCard = page.locator('[data-testid^="user-card-"]').filter({ hasText: testUser.name }).first();
    await userCard.locator('[data-testid^="edit-btn-"]').click();

    // Verificar modo edição
    await expect(page.locator('#formTitle')).toContainText('Editar Usuário');
    await expect(page.locator('#cancelBtn')).toBeVisible();

    // Alterar dados sem salvar
    await page.fill('#name', 'Nome Alterado');

    // Cancelar edição
    await page.click('#cancelBtn');

    // Verificar se voltou ao modo normal
    await expect(page.locator('#formTitle')).toContainText('Cadastrar Novo Usuário');
    await expect(page.locator('#submitBtn')).toContainText('Cadastrar Usuário');
    await expect(page.locator('#cancelBtn')).not.toBeVisible();
    await expect(page.locator('#name')).toHaveValue('');
  });

  test('Deve exibir mensagem quando não há usuários', async ({ page }) => {
    // Interceptar requisição GET para retornar lista vazia
    await page.route('**/api/users', route => {
      route.fulfill({
        contentType: 'application/json',
        body: JSON.stringify({
          success: true,
          data: [],
          total: 0
        })
      });
    });

    // Recarregar página
    await page.reload();
    await page.waitForLoadState('networkidle');

    // Verificar mensagem de "nenhum usuário"
    await expect(page.locator('.no-users')).toContainText('Nenhum usuário cadastrado');
  });
});
