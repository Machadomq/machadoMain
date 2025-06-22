# Guia de Instalação e Execução

## Pré-requisitos
- Python 3.8 ou superior
- MySQL Server
- Git (opcional)

## Passo 1: Configurar o Banco de Dados

1. Instale o MySQL Server
2. Crie o banco de dados executando o arquivo `database.sql`
3. Configure as credenciais no arquivo `.env`

```sql
-- Execute no MySQL
source database.sql;
```

## Passo 2: Instalar Dependências

```bash
pip install -r requirements.txt
```

## Passo 3: Configurar Variáveis de Ambiente

Edite o arquivo `.env` com suas configurações:

```
MYSQL_HOST=localhost
MYSQL_USER=root
MYSQL_PASSWORD=sua_senha_mysql
MYSQL_DB=game_conquests_db
SECRET_KEY=sua_chave_secreta_jwt
```

## Passo 4: Executar a API

```bash
python app.py
```

A API estará disponível em: http://localhost:5000

## Testando com Insomnia

### 1. Registrar Usuário
```
POST http://localhost:5000/api/register
Body (JSON):
{
    "username": "jogador1",
    "password": "minhasenha"
}
```

### 2. Fazer Login
```
POST http://localhost:5000/api/login
Body (JSON):
{
    "username": "jogador1",
    "password": "minhasenha"
}
```

### 3. Completar Fase (usar token do login)
```
POST http://localhost:5000/api/progress
Headers: Authorization: Bearer SEU_TOKEN_AQUI
Body (JSON):
{
    "stage_name": "fase1"
}
```

### 4. Ver Conquistas do Usuário
```
GET http://localhost:5000/api/achievements/1
Headers: Authorization: Bearer SEU_TOKEN_AQUI
```
