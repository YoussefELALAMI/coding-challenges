SELECT name FROM Employee as e1
JOIN
    (SELECT managerId FROM Employee
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5) as e2
WHERE e2.managerId = e1.id