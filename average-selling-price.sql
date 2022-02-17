SELECT
    s.product_id,
    round(sum(s.units * p.price) / sum(s.units), 2) AS average_price
FROM
    UnitsSold s
    JOIN Prices p ON p.product_id = s.product_id
    AND s.purchase_date BETWEEN p.start_date
    AND p.end_date
GROUP BY
    s.product_id