# Write your MySQL query statement below
SELECT MAX(num) AS num
FROM(
    SELECT num
    FROM MyNumbers
    GROUP By num
    HAVING COUNT(*)<2
)t;
