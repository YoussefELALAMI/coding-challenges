SELECT 
    d.name as Department,
    e.name as Employee,
    e.salary as Salary
FROM Employee as e
JOIN Department as d
ON e.departmentId = d.id
WHERE (e.departmentId, e.salary)
IN (
    SELECT departmentId, MAX(Salary)
    FROM
        Employee
    GROUP BY departmentId
)