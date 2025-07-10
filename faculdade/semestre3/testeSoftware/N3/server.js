const express = require('express');
const cors = require('cors');
const { v4: uuidv4 } = require('uuid');

const app = express();
const PORT = 3001;

// Middleware
app.use(cors());
app.use(express.json());
app.use(express.static('public'));

// Banco de dados em memória (simples)
let users = [
  { id: '1', name: 'João Silva', email: 'joao@email.com', age: 30 },
  { id: '2', name: 'Maria Santos', email: 'maria@email.com', age: 25 }
];

// GET - Listar todos os usuários
app.get('/api/users', (req, res) => {
  res.json({
    success: true,
    data: users,
    total: users.length
  });
});

// GET - Buscar usuário por ID
app.get('/api/users/:id', (req, res) => {
  const user = users.find(u => u.id === req.params.id);
  
  if (!user) {
    return res.status(404).json({
      success: false,
      message: 'Usuário não encontrado'
    });
  }
  
  res.json({
    success: true,
    data: user
  });
});

// POST - Criar novo usuário
app.post('/api/users', (req, res) => {
  const { name, email, age } = req.body;
  
  // Validação simples
  if (!name || !email || !age) {
    return res.status(400).json({
      success: false,
      message: 'Nome, email e idade são obrigatórios'
    });
  }
  
  // Verificar se email já existe
  const existingUser = users.find(u => u.email === email);
  if (existingUser) {
    return res.status(400).json({
      success: false,
      message: 'Email já cadastrado'
    });
  }
  
  const newUser = {
    id: uuidv4(),
    name,
    email,
    age: parseInt(age)
  };
  
  users.push(newUser);
  
  res.status(201).json({
    success: true,
    data: newUser,
    message: 'Usuário criado com sucesso'
  });
});

// PUT - Atualizar usuário
app.put('/api/users/:id', (req, res) => {
  const { name, email, age } = req.body;
  const userId = req.params.id;
  
  const userIndex = users.findIndex(u => u.id === userId);
  
  if (userIndex === -1) {
    return res.status(404).json({
      success: false,
      message: 'Usuário não encontrado'
    });
  }
  
  // Validação simples
  if (!name || !email || !age) {
    return res.status(400).json({
      success: false,
      message: 'Nome, email e idade são obrigatórios'
    });
  }
  
  // Verificar se email já existe (exceto o próprio usuário)
  const existingUser = users.find(u => u.email === email && u.id !== userId);
  if (existingUser) {
    return res.status(400).json({
      success: false,
      message: 'Email já cadastrado'
    });
  }
  
  users[userIndex] = {
    ...users[userIndex],
    name,
    email,
    age: parseInt(age)
  };
  
  res.json({
    success: true,
    data: users[userIndex],
    message: 'Usuário atualizado com sucesso'
  });
});

// DELETE - Deletar usuário
app.delete('/api/users/:id', (req, res) => {
  const userId = req.params.id;
  const userIndex = users.findIndex(u => u.id === userId);
  
  if (userIndex === -1) {
    return res.status(404).json({
      success: false,
      message: 'Usuário não encontrado'
    });
  }
  
  const deletedUser = users.splice(userIndex, 1)[0];
  
  res.json({
    success: true,
    data: deletedUser,
    message: 'Usuário deletado com sucesso'
  });
});

// Middleware para tratar erros
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).json({
    success: false,
    message: 'Erro interno do servidor'
  });
});

// Iniciar servidor
app.listen(PORT, () => {
  console.log(`🚀 Servidor rodando em http://localhost:${PORT}`);
  console.log(`📝 API disponível em http://localhost:${PORT}/api/users`);
});

module.exports = app;
