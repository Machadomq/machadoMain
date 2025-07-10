# 🚀 Sistema CRUD Completo

Sistema simples de CRUD (Create, Read, Update, Delete) com API REST, frontend, testes de carga e testes funcionais.

##  Componentes do Sistema

1. **API REST** (Node.js/Express) - Operações CRUD para usuários
2. **Frontend** (HTML/CSS/JavaScript) - Interface para gerenciar usuários
3. **Testes de Carga** (Grafana K6) - Testes de performance da API
4. **Dashboard** (Grafana) - Visualização dos resultados dos testes
5. **Testes Funcionais** (Playwright) - Testes automatizados do frontend

##  Pré-requisitos

- Node.js (v14 ou superior)
- npm ou yarn
- Docker e Docker Compose (para Grafana)
- K6 (para testes de carga)

##  Como executar

### 1. Instalar dependências

```bash
npm install
```

### 2. Executar a API e Frontend

```bash
npm start
```

A aplicação estará disponível em: http://localhost:3001

### 3. Executar o Grafana e InfluxDB

```bash
docker-compose up -d
```

- Grafana: http://localhost:3002 (admin/admin)
- InfluxDB: http://localhost:8086

### 4. Executar testes de carga

```bash
# Instalar K6 (se não estiver instalado)
# Windows: choco install k6
# macOS: brew install k6
# Linux: seguir instruções em k6.io

# Executar testes com saída para InfluxDB
k6 run --out influxdb=http://localhost:8086/k6 k6-tests.js
```

### 5. Instalar e executar testes funcionais

```bash
# Instalar Playwright
npx playwright install

# Executar testes
npm test
```

##  API Endpoints

### GET /api/users
- Lista todos os usuários
- Retorna array de usuários com ID, nome, email e idade

### POST /api/users
- Cria um novo usuário
- Body: `{ "name": "string", "email": "string", "age": number }`

### PUT /api/users/:id
- Atualiza um usuário existente
- Body: `{ "name": "string", "email": "string", "age": number }`

### DELETE /api/users/:id
- Remove um usuário
- Retorna o usuário removido

## 🎯 Funcionalidades do Frontend

- ✅ Formulário de cadastro de usuários
- ✅ Listagem de usuários em cards
- ✅ Edição de usuários existentes
- ✅ Exclusão de usuários
- ✅ Validação de formulários
- ✅ Mensagens de feedback
- ✅ Design responsivo e moderno

## 🧪 Testes Implementados

### Testes de Carga (K6)
- Testa todas as operações CRUD
- Simula 10 usuários simultâneos
- Verifica tempo de resposta < 500ms
- Monitora taxa de erro < 10%

### Testes Funcionais (Playwright)
- Testa criação de usuários
- Testa listagem de usuários
- Testa edição de usuários
- Testa exclusão de usuários
- Testa validações de formulário
- Testa cancelamento de edição

## 📈 Dashboard do Grafana

O dashboard inclui:
- Total de requisições
- Taxa de requisições por segundo
- Tempos de resposta (média e percentil 95)
- Códigos de status HTTP
- Taxa de erro
- Número de usuários virtuais

## 🔧 Estrutura do Projeto

```
├── server.js              # Servidor da API
├── package.json           # Dependências do projeto
├── k6-tests.js           # Testes de carga K6
├── playwright.config.js   # Configuração do Playwright
├── docker-compose.yml     # Docker para Grafana/InfluxDB
├── public/               # Frontend
│   ├── index.html        # Página principal
│   └── script.js         # JavaScript do frontend
├── tests/                # Testes funcionais
│   └── crud.spec.js      # Testes Playwright
└── grafana/              # Configuração do Grafana
    ├── dashboards/       # Dashboards
    └── provisioning/     # Configuração automática
```

## 🌟 Características do Sistema

- **Simples e Funcional**: Interface limpa e fácil de usar
- **Responsivo**: Funciona bem em dispositivos móveis e desktop
- **Validações**: Campos obrigatórios e validação de email
- **Feedback Visual**: Mensagens de sucesso e erro
- **Testes Abrangentes**: Cobertura completa das funcionalidades
- **Monitoramento**: Dashboard para acompanhar performance

## 🎨 Design

- Design moderno com gradientes
- Cards para exibir usuários
- Ícones para melhor experiência visual
- Cores consistentes e acessíveis
- Animações suaves de hover

## 🚨 Observações

Este é um sistema educacional/demonstrativo que usa:
- Banco de dados em memória (dados não persistem)
- Configurações básicas de segurança
- Ideal para aprendizado e testes
