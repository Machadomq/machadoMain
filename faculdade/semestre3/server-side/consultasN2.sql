-- Consulta 1: Séries europeias com atores com mais de 45 anos
SELECT DISTINCT s.nomeSerie
FROM series s
JOIN paises p ON s.idPais = p.idPais
JOIN temporadas t ON t.idSerie = s.idSerie
JOIN episodios e ON e.idTemporada = t.idTemporada
JOIN ator_participa_episodio ape ON ape.idEpisodio = e.idEpisodio
JOIN atores a ON a.idAtor = ape.idAtor
WHERE p.Pais IN ('Inglaterra', 'Espanha', 'França', 'Itália', 'Alemanha', 'Portugal', 'Bélgica', 'Dinamarca')
AND YEAR(CURDATE()) - YEAR(a.nascimentoAtor) > 45;

-- Consulta 2: Séries dirigidas por um ator participante
SELECT DISTINCT s.nomeSerie
FROM series s
JOIN temporadas t ON t.idSerie = s.idSerie
JOIN episodios e ON e.idTemporada = t.idTemporada
JOIN diretor_dirige_episodio dde ON dde.idEpisodio = e.idEpisodio
JOIN diretores d ON d.idDiretor = dde.idDiretor
JOIN ator_participa_episodio ape ON ape.idEpisodio = e.idEpisodio
JOIN atores a ON a.idAtor = ape.idAtor
WHERE d.nomeDiretor = a.nomeAtor;

-- Consulta 3: Séries não europeias com episódios dirigidos por mais de um diretor
SELECT DISTINCT s.nomeSerie
FROM series s
JOIN paises p ON s.idPais = p.idPais
WHERE p.Pais NOT IN ('Inglaterra', 'Espanha', 'França', 'Itália', 'Alemanha', 'Portugal', 'Bélgica', 'Dinamarca')
AND EXISTS (
    SELECT e.idEpisodio
    FROM episodios e
    JOIN temporadas t ON e.idTemporada = t.idTemporada
    JOIN diretor_dirige_episodio dde ON dde.idEpisodio = e.idEpisodio
    WHERE t.idSerie = s.idSerie
    GROUP BY e.idEpisodio
    HAVING COUNT(DISTINCT dde.idDiretor) > 1
);

-- Consulta 4: Séries antes de 2003, gênero aventura, faixa etária > 12 anos
-- Corrigir, colocar series de aventura antes de 2003 
SELECT s.nomeSerie, COUNT(DISTINCT e.idEpisodio) as total_episodios
FROM series s
JOIN generos g ON s.idGenero = g.idGenero
JOIN temporadas t ON t.idSerie = s.idSerie
JOIN episodios e ON e.idTemporada = t.idTemporada
WHERE YEAR(s.dataLancamentoSerie) < 2003
AND g.genero = 'aventura'
GROUP BY s.nomeSerie;

-- Consulta 5: Personagens e atores de séries de romance com mesma inicial
SELECT p.nomePersonagem, a.nomeAtor
FROM personagens p
JOIN ator_personagem_episodio ape ON p.idPersonagem = ape.idPersonagem
JOIN atores a ON a.idAtor = ape.idAtor
JOIN episodios e ON e.idEpisodio = ape.idEpisodio
JOIN temporadas t ON t.idTemporada = e.idTemporada
JOIN series s ON s.idSerie = t.idSerie
JOIN generos g ON g.idGenero = s.idGenero
WHERE g.genero = 'Romance'
AND LEFT(p.nomePersonagem, 1) = LEFT(a.nomeAtor, 1);

-- Consulta 6: Episódios de séries com mais de 3 temporadas e classificação livre
SELECT e.nomeEpisodio
FROM episodios e
JOIN temporadas t ON e.idTemporada = t.idTemporada
JOIN series s ON t.idSerie = s.idSerie
JOIN faixasetarias f ON s.idFaixaEtaria = f.idFaixaEtaria
WHERE f.faixaEtaria = 'livre'
ORDER BY e.nomeEpisodio;faixasetarias

-- Consulta 7: Séries após 2003 com atores em episódios > 45 minutos
SELECT DISTINCT s.nomeSerie
FROM series s
JOIN temporadas t ON t.idSerie = s.idSerie
JOIN episodios e ON e.idTemporada = t.idTemporada
JOIN ator_participa_episodio ape ON ape.idEpisodio = e.idEpisodio
WHERE YEAR(s.dataLancamentoSerie) > 2003
AND TIME_TO_SEC(e.duracaoEpisodio) > 45*60;

-- Consulta 8: Episódios com mínimo 4 episódios > 45 min por temporada e < 3 atores
SELECT e.nomeEpisodio
FROM episodios e
WHERE TIME_TO_SEC(e.duracaoEpisodio) > 45*60
AND e.idTemporada IN (
    SELECT e2.idTemporada
    FROM episodios e2
    WHERE TIME_TO_SEC(e2.duracaoEpisodio) > 45*60
    GROUP BY e2.idTemporada
    HAVING COUNT(*) >= 4
)
AND (
    SELECT COUNT(DISTINCT ape.idAtor)
    FROM ator_participa_episodio ape
    WHERE ape.idEpisodio = e.idEpisodio
) < 3;

-- Consulta 9: Séries com episódios < 33 min, ator interpretando a si mesmo, antes de 2010, não EUA
SELECT DISTINCT s.nomeSerie
FROM series s
JOIN temporadas t ON t.idSerie = s.idSerie
JOIN episodios e ON e.idTemporada = t.idTemporada
WHERE TIME_TO_SEC(e.duracaoEpisodio) < 33*60
AND YEAR(s.dataLancamentoSerie) < 2010;

-- Consulta 10: Episódios, atores e avaliações de séries com avaliação média > 7.5, duração média 45-50 min, gênero comédia ou ação
SELECT e.nomeEpisodio, a.nomeAtor, e.avaliacaoEpisodio
FROM episodios e
JOIN temporadas t ON e.idTemporada = t.idTemporada
JOIN series s ON t.idSerie = s.idSerie
JOIN generos g ON s.idGenero = g.idGenero
JOIN ator_participa_episodio ape ON ape.idEpisodio = e.idEpisodio
JOIN atores a ON a.idAtor = ape.idAtor
WHERE g.genero IN ('ação', 'Comédia')
AND s.idSerie IN (
    SELECT t2.idSerie
    FROM episodios e2
    JOIN temporadas t2 ON e2.idTemporada = t2.idTemporada
    GROUP BY t2.idSerie
    HAVING AVG(e2.avaliacaoEpisodio) > 7.5
)
AND s.idSerie IN (
    SELECT t3.idSerie
    FROM episodios e3
    JOIN temporadas t3 ON e3.idTemporada = t3.idTemporada
    GROUP BY t3.idSerie
    HAVING AVG(TIME_TO_SEC(e3.duracaoEpisodio)/60) BETWEEN 45 AND 50
);
