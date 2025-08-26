SELECT s1.score,
    (
        SELECT COUNT(DISTINCT s2.score)
        FROM Scores as s2
        WHERE s2.score >= s1.score
    ) as 'rank'
FROM Scores as s1
ORDER BY score DESC