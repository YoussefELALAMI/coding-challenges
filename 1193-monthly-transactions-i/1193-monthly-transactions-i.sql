SELECT 
    LEFT(trans_date, 7) AS month,
    country,
    COUNT(state) AS trans_count,
    COUNT(CASE state WHEN 'approved' THEN 1 ELSE null END) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE state WHEN 'approved' THEN amount ELSE 0 END) AS approved_total_amount
FROM Transactions
GROUP BY country, LEFT(trans_date, 7)