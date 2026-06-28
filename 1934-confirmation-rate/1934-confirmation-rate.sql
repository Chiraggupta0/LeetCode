# Write your MySQL query statement below
SELECT s1.user_id , 
ROUND(
    IFNULL(SUM(c1.action='confirmed') / COUNT(c1.action),0),
    2
) AS confirmation_rate 
FROM Signups as s1
LEFT JOIN Confirmations as c1
ON s1.user_id = c1.user_id 
GROUP BY s1.user_id