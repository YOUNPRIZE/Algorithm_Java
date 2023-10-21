WITH NEW AS (
SELECT DISTINCT(CART_ID) CART_ID
FROM CART_PRODUCTS
WHERE NAME = 'Yogurt'
UNION ALL
SELECT DISTINCT(CART_ID) CART_ID
FROM CART_PRODUCTS
WHERE NAME = 'Milk'
)

SELECT CART_ID
FROM NEW
GROUP BY CART_ID
HAVING COUNT(*) > 1
ORDER BY CART_ID