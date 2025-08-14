SELECT name FROM Employee AS e1
JOIN
    (SELECT managerId FROM Employee
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5) AS e2
ON e2.managerId = e1.id;