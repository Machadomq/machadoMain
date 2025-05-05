# Descritivo da API de Jogo - Flask Backend

## 1. Descrição Geral do Jogo (Exemplo)

Este backend foi desenvolvido para um jogo de RPG de fantasia (nome a definir), onde os jogadores criam personagens, exploram cenários, progridem de nível, enfrentam desafios e chefes, e têm seu progresso salvo para continuar a aventura posteriormente. A API gerencia os dados essenciais do jogador e do mundo do jogo.

*(Nota: Esta é uma descrição genérica. O grupo deve adaptar esta seção para descrever brevemente o jogo específico do seu projeto PAC.)*

## 2. Descrição do Funcionamento da API e Tópicos

A API foi construída utilizando Flask, seguindo uma arquitetura modular com Blueprints para organizar as rotas de cada entidade principal do jogo. Ela oferece endpoints RESTful para operações CRUD (Create, Read, Update, Delete) sobre os seguintes recursos:

*   **Players (Personagens/Jogadores):** `/api/players/`
    *   Armazena informações básicas do jogador, como nome. Campos adicionais para inventário, armaduras, equipamentos, etc., foram previstos no modelo (`Player`), mas a lógica de manipulação detalhada (ex: adicionar/remover item) não foi implementada nesta versão inicial, podendo ser adicionada futuramente.
    *   **Justificativa:** Centraliza os dados do jogador, permitindo fácil acesso e modificação.
*   **Level Progress (Progresso de Nível):** `/api/level_progress/`
    *   Registra o nível atual e os pontos de experiência de cada jogador. O modelo (`LevelProgress`) prevê campos para recompensas e missões, que podem ser expandidos.
    *   **Justificativa:** Permite acompanhar a evolução do jogador e implementar mecânicas de progressão.
*   **Game Progress (Progresso do Jogo):** `/api/game_progress/`
    *   Salva o estado do jogo para cada jogador, incluindo o cenário atual, tipo de rota (principal, secundária, secreta), tempo de conclusão, modo de jogo (fácil, médio, difícil) e estilo (coop, solo). Inclui um campo `save_state_data` (texto) para armazenar dados específicos necessários para continuar o jogo (ex: posição, estado de quests em formato JSON).
    *   **Justificativa:** Essencial para a funcionalidade de "salvar/continuar" o jogo.
*   **Boss Challenges (Desafios de Chefes):** `/api/boss_challenges/`
    *   Registra informações sobre as tentativas de derrotar chefes, como nome do chefe, número de tentativas, estilo de jogo, pontos ganhos e tempo no desafio.
    *   **Justificativa:** Permite analisar a dificuldade dos desafios e o desempenho dos jogadores.
*   **Additional Data (Dados Adicionais):** `/api/additional_data/`
    *   Uma tabela flexível para armazenar outros dados relevantes do jogo que não se encaixam nas categorias principais, como interações com NPCs, marcos alcançados, pontuações específicas, etc. Utiliza um sistema chave-valor associado a um tipo de dado.
    *   **Justificativa:** Oferece extensibilidade para registrar informações diversas sem a necessidade de criar novas tabelas para cada pequeno detalhe.

## 3. Justificativas Tecnológicas

*   **Linguagem e Framework:** Python com Flask foi escolhido pela sua simplicidade, flexibilidade e por ser um dos frameworks apresentados em aula. Sua natureza minimalista permite um desenvolvimento rápido, enquanto sua extensibilidade com Blueprints facilita a organização do código em módulos lógicos.
*   **Banco de Dados:** Foi utilizado um banco de dados relacional (MySQL, configurado por padrão no template). Bancos relacionais são adequados para dados estruturados como os de personagens, progresso e desafios, garantindo consistência e integridade através de relacionamentos (Foreign Keys).
*   **ORM:** SQLAlchemy foi utilizado como ORM (Object-Relational Mapper). Ele simplifica a interação com o banco de dados, permitindo manipular tabelas e registros como objetos Python, abstraindo a escrita de SQL puro e facilitando a manutenção do código. A definição dos modelos (`models/`) e a interação nas rotas (`routes/`) utilizam SQLAlchemy.
*   **Arquitetura:** Seguiu-se a arquitetura proposta na Aula 08, separando modelos, rotas (Blueprints) e a configuração principal da aplicação (`main.py`). A instância do banco de dados (`db`) foi movida para um arquivo separado (`database.py`) para evitar importações circulares, uma prática comum em projetos Flask maiores.
*   **Processo de Login:** A API atual não implementa um sistema de autenticação/login. Para uma versão futura, tecnologias como Flask-Login, Flask-JWT-Extended poderiam ser utilizadas para gerenciar sessões de usuário ou tokens de autenticação, protegendo os endpoints da API.

## 4. Instruções de Uso e Teste

1.  **Pré-requisitos:** Python 3.x, pip, MySQL (ou outro BD relacional compatível com SQLAlchemy, ajustando a URI de conexão em `src/main.py`).
2.  **Instalação:**
    *   Clone o repositório.
    *   Navegue até a pasta `game_api`.
    *   Crie e ative um ambiente virtual: `python -m venv venv` e `source venv/bin/activate` (ou `venv\Scripts\activate` no Windows).
    *   Instale as dependências: `pip install -r requirements.txt`.
    *   Certifique-se de que o servidor MySQL esteja rodando e acessível com as credenciais padrão (root/password) ou configure as variáveis de ambiente `DB_USERNAME`, `DB_PASSWORD`, `DB_HOST`, `DB_PORT`, `DB_NAME`.
3.  **Execução:**
    *   No diretório `game_api`, execute: `python src/main.py`.
    *   A API estará disponível em `http://localhost:5000`.
4.  **Teste com Postman/Insomnia/curl:**
    *   Utilize uma ferramenta como Postman ou Insomnia (ou `curl` via terminal) para enviar requisições aos endpoints da API.
    *   **Exemplo (Criar Jogador):** `POST http://localhost:5000/api/players/` com corpo JSON: `{"name": "NomeDoJogador"}`.
    *   **Exemplo (Listar Jogadores):** `GET http://localhost:5000/api/players/`.
    *   Consulte os arquivos em `src/routes/` para ver todos os endpoints disponíveis e os métodos HTTP esperados (GET, POST, PUT, DELETE) para cada entidade.
    *   Uma coleção Postman/Insomnia (`api_collection.json`) pode ser fornecida para facilitar os testes.

*(Nota: O grupo deve adicionar aqui a coleção Postman/Insomnia exportada, se criada.)*
