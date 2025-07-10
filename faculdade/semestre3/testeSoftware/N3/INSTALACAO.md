#  SISTEMA CRUD COMPLETO - INSTRUÇÕES DE INSTALAÇÃO

##  O que foi criado:

###  **Sistema Completo com:**
- ✅ **API REST** (Node.js/Express) com GET, POST, PUT, DELETE
- ✅ **Frontend** (HTML/CSS/JavaScript) com formulário responsivo
- ✅ **Testes de Carga** (Grafana K6) para as 4 operações
- ✅ **Dashboard** (Grafana) para visualizar métricas
- ✅ **Testes Funcionais** (Playwright) para as 4 operações

---

##  **1. INSTALAÇÃO RÁPIDA**

### No Windows:
```bash
# 1. Instalar dependências
npm install

# 2. Instalar Playwright browsers
npx playwright install

# 3. Iniciar aplicação
npm start
```

### Ou execute o script pronto:
```bash
start.bat
```

---

##  **2. ACESSAR O SISTEMA**

### 📱 **Aplicação Principal:**
- **URL:** http://localhost:3001
- **Funcionalidades:**
  - Cadastrar usuários
  - Listar usuários
  - Editar usuários
  - Excluir usuários

###  **Dashboard Grafana:**
```bash
# Iniciar Grafana e InfluxDB
docker-compose up -d

# Acessar dashboard
# URL: http://localhost:3002
# Login: admin / admin
```

---

##  **3. EXECUTAR TESTES**

### **Testes Funcionais (Playwright):**
```bash
# Executar todos os testes
npm test

# Executar com interface gráfica
npx playwright test --ui

# Executar apenas no Chrome
npx playwright test --project=chromium
```

### **Testes de Carga (K6):**
```bash
# Instalar K6 primeiro:
# Windows: choco install k6
# Mac: brew install k6

# Executar testes de carga
k6 run k6-tests.js

# Executar com métricas para Grafana
k6 run --out influxdb=http://localhost:8086/k6 k6-tests.js
```

---

##  **4. ESTRUTURA DO PROJETO**

```
 Sistema CRUD
├──  server.js           # API REST (Node.js/Express)
├──  public/             # Frontend
│   ├── index.html         # Interface principal
│   └── script.js          # JavaScript do frontend
├──  tests/              # Testes funcionais
│   └── crud.spec.js       # Testes Playwright
├──  k6-tests.js         # Testes de carga
├──  docker-compose.yml  # Grafana + InfluxDB
├──  grafana/            # Configuração do dashboard
└──  README.md           # Documentação
```

---

##  **5. FUNCIONALIDADES TESTADAS**

### **API REST:**
-  GET /api/users (listar usuários)
-  POST /api/users (criar usuário)
-  PUT /api/users/:id (atualizar usuário)
-  DELETE /api/users/:id (excluir usuário)

### **Frontend:**
-  Formulário de cadastro
-  Listagem em cards
-  Edição inline
-  Exclusão com confirmação
-  Validação de campos
-  Mensagens de feedback

### **Testes de Carga:**
-  Simula 10 usuários simultâneos
-  Testa todas as operações CRUD
-  Verifica tempo de resposta < 500ms
-  Monitora taxa de erro < 10%

### **Testes Funcionais:**
-  Testa criação de usuários
-  Testa listagem de usuários
-  Testa edição de usuários
-  Testa exclusão de usuários
-  Testa validações de formulário

---

##  **6. CARACTERÍSTICAS DO SISTEMA**

### **Design:**
-  Interface moderna com gradientes
-  Responsivo para mobile e desktop
-  Cards elegantes para exibir usuários
-  Notificações de sucesso/erro
-  Animações suaves

### **Funcionalidades:**
-  Validação de campos obrigatórios
-  Validação de email único
-  Validação de idade (1-120 anos)
-  Atualização automática da lista
-  Dados persistem durante execução

### **Testes:**
-  24 testes funcionais (3 browsers)
-  Testes de carga com métricas
-  Dashboard visual no Grafana
-  Relatórios HTML automáticos

---

##  **7. OBSERVAÇÕES IMPORTANTES**

### **Banco de Dados:**
-  Usa memória (dados não persistem após reiniciar)
-  Perfeito para desenvolvimento e testes
-  Fácil de expandir para banco real

### **Segurança:**
-  Configuração básica para desenvolvimento
-  Validações no frontend e backend
-  CORS habilitado para testes

### **Performance:**
-  Resposta rápida (< 500ms)
-  Otimizado para testes de carga
-  Monitoramento via Grafana

---

##  **8. RESUMO - SISTEMA FUNCIONANDO**

### ** Componentes Implementados:**
1. **API REST** - 4 endpoints CRUD funcionais
2. **Frontend** - Interface completa e responsiva
3. **Testes K6** - Testes de carga das 4 operações
4. **Dashboard** - Grafana com métricas detalhadas
5. **Testes Playwright** - Testes funcionais automatizados

### ** Requisitos Atendidos:**
-  API REST com GET, POST, PUT, DELETE
-  Frontend com formulário para as 4 operações
-  Testes de carga K6 nas 4 operações
-  Dashboard Grafana para visualizar testes
-  Testes funcionais Playwright nas 4 operações

### ** Como usar:**
1. Execute `npm install`
2. Execute `npm start`
3. Acesse `http://localhost:3001`
4. Execute `npm test` para testes funcionais
5. Execute `k6 run k6-tests.js` para testes de carga

---

##  **9. SOLUÇÃO DE PROBLEMAS**

### **Porta em uso:**
- O sistema usa porta 3001 (se 3000 estiver ocupada)
- Grafana usa porta 3002

### **Testes falhando:**
- Certifique-se que o servidor esteja rodando
- Aguarde alguns segundos para o sistema inicializar

### **K6 não instalado:**
- Windows: `choco install k6`
- Mac: `brew install k6`
- Linux: Seguir instruções em k6.io

### **Docker não funcionando:**
- Certifique-se que o Docker esteja rodando
- Execute `docker-compose up -d`

---

##  **10. SUPORTE**

**Sistema criado com:**
- Node.js + Express (API)
- HTML + CSS + JavaScript (Frontend)
- Playwright (Testes Funcionais)
- Grafana K6 (Testes de Carga)
- Grafana + InfluxDB (Dashboard)

**Totalmente funcional e pronto para uso!** 🎉
