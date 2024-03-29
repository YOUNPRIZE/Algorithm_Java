-- 코드를 입력하세요

SELECT O.CAR_ID,
CASE
    WHEN O.CAR_ID in (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'
        GROUP BY CAR_ID
        ) THEN '대여중'
    ELSE '대여 가능'
END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY O
GROUP BY O.CAR_ID
ORDER BY O.CAR_ID DESC;