-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, SUM(P.PRICE * O.SALES_AMOUNT) AS SALES
FROM PRODUCT P INNER JOIN OFFLINE_SALE O ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE

# select a.PRODUCT_CODE, SUM(a.price*b.sales_amount)as SALES
# from product a
#      inner join offline_sale b on a.product_id = b.product_id
# group by a.product_code
# order by 2 desc,1