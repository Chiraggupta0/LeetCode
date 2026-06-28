# Write your MySQL query statement below
SELECT e.name FROM Employee as e
JOIN Employee as s
ON e.id = s.managerId
GROUP BY e.id
HAVING COUNT(*)>=5