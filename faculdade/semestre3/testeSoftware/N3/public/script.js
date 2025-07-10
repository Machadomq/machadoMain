// Configuração da API
const API_BASE_URL = 'http://localhost:3001/api';

// Variáveis globais
let editingUserId = null;
let users = [];

// Elementos DOM
const userForm = document.getElementById('userForm');
const usersContainer = document.getElementById('usersContainer');
const alertContainer = document.getElementById('alertContainer');
const formTitle = document.getElementById('formTitle');
const submitBtn = document.getElementById('submitBtn');
const cancelBtn = document.getElementById('cancelBtn');

// Inicializar aplicação
document.addEventListener('DOMContentLoaded', () => {
    loadUsers();
    setupEventListeners();
});

// Configurar event listeners
function setupEventListeners() {
    userForm.addEventListener('submit', handleFormSubmit);
    cancelBtn.addEventListener('click', cancelEdit);
}

// Carregar usuários
async function loadUsers() {
    try {
        showLoading();
        const response = await fetch(`${API_BASE_URL}/users`);
        const data = await response.json();
        
        if (data.success) {
            users = data.data;
            displayUsers();
        } else {
            throw new Error(data.message || 'Erro ao carregar usuários');
        }
    } catch (error) {
        console.error('Erro ao carregar usuários:', error);
        showAlert('Erro ao carregar usuários: ' + error.message, 'error');
        usersContainer.innerHTML = '<div class="no-users">❌ Erro ao carregar usuários</div>';
    }
}

// Exibir usuários
function displayUsers() {
    if (users.length === 0) {
        usersContainer.innerHTML = '<div class="no-users">📭 Nenhum usuário cadastrado</div>';
        return;
    }

    const usersHTML = users.map(user => `
        <div class="user-card" data-testid="user-card-${user.id}">
            <h3> ${user.name}</h3>
            <p> <strong>Email:</strong> ${user.email}</p>
            <p> <strong>Idade:</strong> ${user.age} anos</p>
            <p> <strong>ID:</strong> ${user.id}</p>
            <div class="actions">
                <button class="btn btn-edit" onclick="editUser('${user.id}')" data-testid="edit-btn-${user.id}">
                     Editar
                </button>
                <button class="btn btn-danger" onclick="deleteUser('${user.id}')" data-testid="delete-btn-${user.id}">
                     Excluir
                </button>
            </div>
        </div>
    `).join('');

    usersContainer.innerHTML = `<div class="users-grid">${usersHTML}</div>`;
}

// Manipular envio do formulário
async function handleFormSubmit(e) {
    e.preventDefault();
    
    const formData = new FormData(userForm);
    const userData = {
        name: formData.get('name').trim(),
        email: formData.get('email').trim(),
        age: parseInt(formData.get('age'))
    };

    if (editingUserId) {
        await updateUser(editingUserId, userData);
    } else {
        await createUser(userData);
    }
}

// Criar usuário
async function createUser(userData) {
    try {
        submitBtn.disabled = true;
        submitBtn.textContent = 'Criando...';
        
        const response = await fetch(`${API_BASE_URL}/users`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });

        const data = await response.json();
        
        if (data.success) {
            showAlert('✅ Usuário criado com sucesso!', 'success');
            userForm.reset();
            loadUsers();
        } else {
            throw new Error(data.message || 'Erro ao criar usuário');
        }
    } catch (error) {
        console.error('Erro ao criar usuário:', error);
        showAlert('❌ Erro ao criar usuário: ' + error.message, 'error');
    } finally {
        submitBtn.disabled = false;
        submitBtn.textContent = 'Cadastrar Usuário';
    }
}

// Editar usuário
async function editUser(userId) {
    const user = users.find(u => u.id === userId);
    if (!user) return;

    // Preencher formulário
    document.getElementById('name').value = user.name;
    document.getElementById('email').value = user.email;
    document.getElementById('age').value = user.age;

    // Alterar interface para modo edição
    editingUserId = userId;
    formTitle.textContent = '✏️ Editar Usuário';
    submitBtn.textContent = 'Atualizar Usuário';
    cancelBtn.style.display = 'inline-block';
    
    // Scroll para o formulário
    document.querySelector('.form-section').scrollIntoView({ behavior: 'smooth' });
}

// Atualizar usuário
async function updateUser(userId, userData) {
    try {
        submitBtn.disabled = true;
        submitBtn.textContent = 'Atualizando...';
        
        const response = await fetch(`${API_BASE_URL}/users/${userId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });

        const data = await response.json();
        
        if (data.success) {
            showAlert('✅ Usuário atualizado com sucesso!', 'success');
            cancelEdit();
            loadUsers();
        } else {
            throw new Error(data.message || 'Erro ao atualizar usuário');
        }
    } catch (error) {
        console.error('Erro ao atualizar usuário:', error);
        showAlert('❌ Erro ao atualizar usuário: ' + error.message, 'error');
    } finally {
        submitBtn.disabled = false;
        submitBtn.textContent = 'Atualizar Usuário';
    }
}

// Excluir usuário
async function deleteUser(userId) {
    if (!confirm('Tem certeza que deseja excluir este usuário?')) return;

    try {
        const response = await fetch(`${API_BASE_URL}/users/${userId}`, {
            method: 'DELETE'
        });

        const data = await response.json();
        
        if (data.success) {
            showAlert('✅ Usuário excluído com sucesso!', 'success');
            loadUsers();
            
            // Se estava editando este usuário, cancelar edição
            if (editingUserId === userId) {
                cancelEdit();
            }
        } else {
            throw new Error(data.message || 'Erro ao excluir usuário');
        }
    } catch (error) {
        console.error('Erro ao excluir usuário:', error);
        showAlert('❌ Erro ao excluir usuário: ' + error.message, 'error');
    }
}

// Cancelar edição
function cancelEdit() {
    editingUserId = null;
    formTitle.textContent = '📝 Cadastrar Novo Usuário';
    submitBtn.textContent = 'Cadastrar Usuário';
    cancelBtn.style.display = 'none';
    userForm.reset();
}

// Mostrar alerta
function showAlert(message, type) {
    const alertClass = type === 'success' ? 'alert-success' : 'alert-error';
    const alertHTML = `
        <div class="alert ${alertClass}" role="alert">
            ${message}
        </div>
    `;
    
    alertContainer.innerHTML = alertHTML;
    
    // Remover alerta após 5 segundos
    setTimeout(() => {
        alertContainer.innerHTML = '';
    }, 5000);
    
    // Scroll para o topo
    alertContainer.scrollIntoView({ behavior: 'smooth' });
}

// Mostrar loading
function showLoading() {
    usersContainer.innerHTML = '<div class="loading">⏳ Carregando usuários...</div>';
}

// Funções globais para os botões (necessárias para onclick inline)
window.editUser = editUser;
window.deleteUser = deleteUser;
