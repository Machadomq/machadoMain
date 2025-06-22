# API de Conquistas do Jogo - Documentação Técnica

## 1. Arquitetura e Tecnologias Utilizadas

### Tecnologias Base
- **Backend**: Flask (Python)
- **Banco de Dados**: MySQL
- **Autenticação**: JWT (JSON Web Tokens)
- **Criptografia**: bcrypt para senhas
- **CORS**: flask-cors para requisições cross-origin

### Bibliotecas e Dependências
- Flask==2.3.3 - Framework web principal
- PyMySQL==1.1.0 - Driver MySQL para Python
- flask-cors==4.0.0 - Habilitação de CORS
- bcrypt==4.0.1 - Hash de senhas
- PyJWT==2.8.0 - Autenticação via tokens
- python-dotenv==1.0.0 - Gerenciamento de variáveis de ambiente

### Processo de Construção
1. **Estrutura MVC**: Separação clara entre rotas, lógica de negócio e acesso a dados
2. **Autenticação Stateless**: Uso de JWT para manter sessões sem estado no servidor
3. **Validação de Dados**: Validações em todas as entradas da API
4. **Tratamento de Erros**: Respostas padronizadas para diferentes tipos de erro

### Comunicação entre Tecnologias
- **Cliente ↔ Flask**: REST API via HTTP/JSON
- **Flask ↔ MySQL**: PyMySQL para conexões e queries
- **Autenticação**: JWT tokens no header Authorization
- **Variáveis de Ambiente**: .env para configurações sensíveis

## 2. Sincronização de Dados

### Estratégia de Sincronização
- **Transações ACID**: Garantia de consistência nas operações
- **Chaves Únicas**: Prevenção de duplicatas (user_id + achievement_id)
- **Timestamps**: Rastreamento temporal de todas as ações
- **Rollback Automático**: Em caso de falha, operações são revertidas

### Fluxo de Dados
1. Usuario completa uma fase
2. Sistema verifica se já existe progresso para essa fase
3. Atualiza tabela user_progress
4. Verifica conquistas disponíveis para a fase
5. Adiciona novas conquistas automaticamente
6. Retorna conquistas obtidas

## 3. Implementações de Segurança e Autenticação

### Autenticação
- **JWT Tokens**: Expiração de 24 horas
- **Bearer Token**: Header Authorization obrigatório
- **Validação**: Verificação de token em rotas protegidas

### Segurança de Dados
- **bcrypt**: Hash das senhas com salt automático
- **SQL Injection**: Uso de queries parametrizadas
- **Validação de Entrada**: Verificação de todos os dados recebidos
- **CORS**: Configuração adequada para requisições cross-origin

### Controle de Acesso
- **Token Required**: Decorator para proteger rotas
- **Verificação de Usuário**: Validação de propriedade dos dados
- **Tratamento de Erros**: Não exposição de informações sensíveis

## 4. Insígnias/Emblemas/Recompensas Disponíveis

### Sistema de Conquistas por Fases
Cada fase possui conquistas específicas que são automaticamente concedidas:

**Fase 1**: Primeiro Passo
**Fase 2**: Explorador Iniciante + Desbravador
**Fase 3**: Solucionador + Pensador
**Fase 4**: Aventureiro + Navegador
**Fase 5**: Mestre dos Puzzles + Estrategista
**Fase 6**: Explorador Profundo + Descobridor
**Fase 7**: Versátil + Equilibrado
**Fase 8**: Gênio + Sábio
**Fase 9**: Explorador Total + Completo
**Fase 10**: Lenda + Imortal

### Características do Sistema
- **19 conquistas totais** distribuídas em 10 fases
- **Progressão linear**: Conquistas desbloqueadas por ordem de fases
- **Múltiplas por fase**: Algumas fases concedem mais de uma conquista
- **Temática consistente**: Foco em exploração e resolução de puzzles

## 5. Coleta e Armazenamento de Dados

### Fontes de Dados
- **Progresso do Jogador**: Fases completadas via endpoint `/api/progress`
- **Dados de Usuário**: Registro e autenticação via `/api/register` e `/api/login`
- **Estatísticas**: Geradas dinamicamente a partir dos dados existentes

### Estrutura de Armazenamento
```sql
users: id, username, password, created_at
stages: id, name, description, order_number, created_at
achievements: id, name, description, stage_id, created_at
user_progress: id, user_id, stage_id, completed_at
user_achievements: id, user_id, achievement_id, earned_at
```

### Relacionamentos
- **1:N** Users → User_Progress
- **1:N** Users → User_Achievements  
- **1:N** Stages → Achievements
- **N:M** Users ↔ Achievements (via user_achievements)

## 6. Lógica de Processamento para Geração de Insígnias

### Algoritmo de Concessão
1. **Trigger por Progresso**: Conquistas são processadas quando usuário completa fase
2. **Verificação de Elegibilidade**: Sistema verifica quais conquistas da fase ainda não foram obtidas
3. **Concessão Automática**: Todas as conquistas da fase são automaticamente concedidas
4. **Prevenção de Duplicatas**: Constraint UNIQUE impede conquistas duplicadas
5. **Timestamp**: Registro do momento exato da conquista

### Query de Processamento
```sql
SELECT a.id, a.name, a.description 
FROM achievements a 
WHERE a.stage_id = %s 
AND a.id NOT IN (
    SELECT achievement_id FROM user_achievements 
    WHERE user_id = %s
)
```

## 7. Escalabilidade e Performance

### Problemas Potenciais com Grandes Volumes

#### Cenários de Risco
- **Usuários Simultâneos**: >1000 usuários completando fases simultaneamente
- **Processamento Massivo**: Cálculo de rankings em tempo real
- **Queries Complexas**: JOINs múltiplos para estatísticas detalhadas

#### Soluções Implementadas
- **Índices de Performance**: Chaves primárias e estrangeiras indexadas
- **Queries Otimizadas**: Uso de LIMIT e ORDER BY estratégicos
- **Conexões Eficientes**: Pool de conexões MySQL

#### Melhorias Futuras Recomendadas
- **Cache Redis**: Para rankings e estatísticas frequentes
- **Processamento Assíncrono**: Para operações não-críticas
- **Particionamento**: Separação de dados por período temporal
- **Load Balancer**: Distribuição de carga entre instâncias

## 8. Rotas de Recuperação de Insígnias

### Endpoint Principal: `/api/achievements/<user_id>`
**Método**: GET
**Autenticação**: Bearer Token obrigatório
**Resposta**:
```json
{
    "user_id": 1,
    "username": "jogador1",
    "achievements": [
        {
            "id": 1,
            "name": "Primeiro Passo",
            "description": "Completou a primeira fase do jogo",
            "stage_name": "fase1",
            "earned_at": "2025-06-22T10:30:00"
        }
    ],
    "total_achievements": 1
}
```

### Endpoints Complementares
- **`/api/achievements`**: Lista todas as conquistas disponíveis
- **`/api/user/stats/<user_id>`**: Estatísticas detalhadas do usuário
- **`/api/leaderboard`**: Ranking dos 10 melhores jogadores

### Funcionalidades de Recuperação
- **Filtro por Usuário**: Conquistas específicas de cada jogador
- **Ordenação Temporal**: Conquistas ordenadas por data de obtenção
- **Informações Completas**: Nome, descrição, fase e timestamp
- **Contadores**: Total de conquistas obtidas vs disponíveis
