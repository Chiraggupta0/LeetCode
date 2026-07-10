-- # Write your MySQL query statement below
-- SELECT (COUNT(*)/COUNT(DISTINCT(customer_id)))*100 AS immediate_percentage
-- FROM Delivery 
-- WHERE (customer_id,order_date) IN(
--     SELECT customer_id,MIN(order_date)
--     FROM Delivery
--     GROUP BY customer_id
-- ) AND order_date = customer_pref_delivery_date
-- GROUP BY customer_id

SELECT
    ROUND(
        AVG(order_date = customer_pref_delivery_date) * 100,
        2
    ) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date)
    FROM Delivery
    GROUP BY customer_id
);