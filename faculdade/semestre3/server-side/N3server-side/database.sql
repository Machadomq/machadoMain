CREATE DATABASE IF NOT EXISTS game_conquests_db;
USE game_conquests_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE stages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    order_number INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE achievements (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    stage_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (stage_id) REFERENCES stages(id) ON DELETE CASCADE
);

CREATE TABLE user_progress (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    stage_id INT NOT NULL,
    completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (stage_id) REFERENCES stages(id) ON DELETE CASCADE,
    UNIQUE KEY unique_user_stage (user_id, stage_id)
);

CREATE TABLE user_achievements (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    achievement_id INT NOT NULL,
    earned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (achievement_id) REFERENCES achievements(id) ON DELETE CASCADE,
    UNIQUE KEY unique_user_achievement (user_id, achievement_id)
);

INSERT INTO stages (name, description, order_number) VALUES
('fase1', 'Primeira fase do jogo - Introducao aos puzzles', 1),
('fase2', 'Segunda fase do jogo - Exploracao basica', 2),
('fase3', 'Terceira fase do jogo - Puzzles intermediarios', 3),
('fase4', 'Quarta fase do jogo - Exploracao avancada', 4),
('fase5', 'Quinta fase do jogo - Puzzles complexos', 5),
('fase6', 'Sexta fase do jogo - Exploracao profunda', 6),
('fase7', 'Setima fase do jogo - Desafios combinados', 7),
('fase8', 'Oitava fase do jogo - Puzzles mestres', 8),
('fase9', 'Nona fase do jogo - Exploracao total', 9),
('fase10', 'Fase final - Conquista suprema', 10);

INSERT INTO achievements (name, description, stage_id) VALUES
('Primeiro Passo', 'Completou a primeira fase do jogo', 1),
('Explorador Iniciante', 'Descobriu os primeiros segredos', 2),
('Solucionador', 'Resolveu puzzles intermediarios', 3),
('Aventureiro', 'Explorou areas avancadas', 4),
('Mestre dos Puzzles', 'Dominou puzzles complexos', 5),
('Explorador Profundo', 'Descobriu segredos ocultos', 6),
('Versatil', 'Combinou exploracao e puzzles', 7),
('Genio', 'Resolveu os puzzles mais dificeis', 8),
('Explorador Total', 'Explorou todas as areas', 9),
('Lenda', 'Conquistou a fase final', 10),
('Desbravador', 'Bonus por completar fase 2', 2),
('Pensador', 'Bonus por completar fase 3', 3),
('Navegador', 'Bonus por completar fase 4', 4),
('Estrategista', 'Bonus por completar fase 5', 5),
('Descobridor', 'Bonus por completar fase 6', 6),
('Equilibrado', 'Bonus por completar fase 7', 7),
('Sabio', 'Bonus por completar fase 8', 8),
('Completo', 'Bonus por completar fase 9', 9),
('Imortal', 'Bonus por completar fase 10', 10);
