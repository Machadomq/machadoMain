import http from 'k6/http';
import { check, sleep } from 'k6';
import { Rate } from 'k6/metrics';

// Métricas customizadas
const errorRate = new Rate('errors');

// Configuração do teste
export const options = {
  stages: [
    { duration: '30s', target: 10 },  // Subir para 10 usuários em 30s
    { duration: '1m', target: 10 },   // Manter 10 usuários por 1min
    { duration: '30s', target: 0 },   // Reduzir para 0 usuários em 30s
  ],
  thresholds: {
    http_req_duration: ['p(95)<500'], // 95% das requisições devem ser < 500ms
    errors: ['rate<0.1'],             // Taxa de erro < 10%
    http_req_failed: ['rate<0.1'],    // Taxa de falha < 10%
  },
};

const BASE_URL = 'http://localhost:3001/api';

// Dados de teste
const testUsers = [
  { name: 'João Silva', email: 'joao@teste.com', age: 30 },
  { name: 'Maria Santos', email: 'maria@teste.com', age: 25 },
  { name: 'Pedro Oliveira', email: 'pedro@teste.com', age: 35 },
  { name: 'Ana Costa', email: 'ana@teste.com', age: 28 },
  { name: 'Carlos Souza', email: 'carlos@teste.com', age: 40 },
];

let createdUserIds = [];

export default function () {
  // Teste GET - Listar usuários
  testGetUsers();
  
  // Teste POST - Criar usuário
  testCreateUser();
  
  // Teste PUT - Atualizar usuário (se houver usuários criados)
  if (createdUserIds.length > 0) {
    testUpdateUser();
  }
  
  // Teste DELETE - Deletar usuário (se houver usuários criados)
  if (createdUserIds.length > 0) {
    testDeleteUser();
  }
  
  sleep(1); // Pausa entre as iterações
}

// Teste GET - Listar usuários
function testGetUsers() {
  console.log('🔍 Testando GET /users');
  
  const response = http.get(`${BASE_URL}/users`);
  
  const success = check(response, {
    'GET /users - Status 200': (r) => r.status === 200,
    'GET /users - Tempo < 500ms': (r) => r.timings.duration < 500,
    'GET /users - Resposta contém success': (r) => {
      try {
        const data = JSON.parse(r.body);
        return data.success === true;
      } catch (e) {
        return false;
      }
    },
  });
  
  errorRate.add(!success);
}

// Teste POST - Criar usuário
function testCreateUser() {
  console.log('➕ Testando POST /users');
  
  const userData = testUsers[Math.floor(Math.random() * testUsers.length)];
  
  // Tornar email único adicionando timestamp
  const uniqueUser = {
    ...userData,
    email: `${userData.email.split('@')[0]}_${Date.now()}@teste.com`
  };
  
  const response = http.post(`${BASE_URL}/users`, JSON.stringify(uniqueUser), {
    headers: { 'Content-Type': 'application/json' },
  });
  
  const success = check(response, {
    'POST /users - Status 201': (r) => r.status === 201,
    'POST /users - Tempo < 500ms': (r) => r.timings.duration < 500,
    'POST /users - Resposta contém success': (r) => {
      try {
        const data = JSON.parse(r.body);
        return data.success === true;
      } catch (e) {
        return false;
      }
    },
  });
  
  // Salvar ID do usuário criado para testes futuros
  if (success && response.status === 201) {
    try {
      const data = JSON.parse(response.body);
      if (data.data && data.data.id) {
        createdUserIds.push(data.data.id);
      }
    } catch (e) {
      console.error('Erro ao parsear resposta do POST:', e);
    }
  }
  
  errorRate.add(!success);
}

// Teste PUT - Atualizar usuário
function testUpdateUser() {
  console.log('✏️ Testando PUT /users/:id');
  
  const userId = createdUserIds[Math.floor(Math.random() * createdUserIds.length)];
  const userData = testUsers[Math.floor(Math.random() * testUsers.length)];
  
  // Tornar email único
  const uniqueUser = {
    ...userData,
    email: `${userData.email.split('@')[0]}_updated_${Date.now()}@teste.com`
  };
  
  const response = http.put(`${BASE_URL}/users/${userId}`, JSON.stringify(uniqueUser), {
    headers: { 'Content-Type': 'application/json' },
  });
  
  const success = check(response, {
    'PUT /users/:id - Status 200': (r) => r.status === 200,
    'PUT /users/:id - Tempo < 500ms': (r) => r.timings.duration < 500,
    'PUT /users/:id - Resposta contém success': (r) => {
      try {
        const data = JSON.parse(r.body);
        return data.success === true;
      } catch (e) {
        return false;
      }
    },
  });
  
  errorRate.add(!success);
}

// Teste DELETE - Deletar usuário
function testDeleteUser() {
  console.log(' Testando DELETE /users/:id');
  
  if (createdUserIds.length === 0) return;
  
  const userId = createdUserIds.pop(); // Remove e retorna o último ID
  
  const response = http.del(`${BASE_URL}/users/${userId}`);
  
  const success = check(response, {
    'DELETE /users/:id - Status 200': (r) => r.status === 200,
    'DELETE /users/:id - Tempo < 500ms': (r) => r.timings.duration < 500,
    'DELETE /users/:id - Resposta contém success': (r) => {
      try {
        const data = JSON.parse(r.body);
        return data.success === true;
      } catch (e) {
        return false;
      }
    },
  });
  
  errorRate.add(!success);
}

// Função de setup (executada uma vez no início)
export function setup() {
  console.log('🚀 Iniciando testes de carga...');
  console.log('📊 Configuração: 10 usuários virtuais por 2 minutos');
  console.log('🎯 Testando todas as operações CRUD');
}

// Função de teardown (executada uma vez no final)
export function teardown() {
  console.log('✅ Testes de carga concluídos!');
  console.log('📈 Verifique os resultados no dashboard do Grafana');
}
