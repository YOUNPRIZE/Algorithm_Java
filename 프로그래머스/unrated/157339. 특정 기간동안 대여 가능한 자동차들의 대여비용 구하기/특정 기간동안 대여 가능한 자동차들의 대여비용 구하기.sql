# WITH CAR AS (
# SELECT *
# FROM CAR_RENTAL_COMPANY_CAR
# WHERE CAR_TYPE = '세단' OR CAR_TYPE = 'SUV')
# , HISTORY AS (
# SELECT *
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE START_DATE > '2022-11-30' OR END_DATE < '2022-11-01')
# , PLAN AS (
# SELECT *
# FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
# WHERE (CAR_TYPE = '세단' AND DURATION_TYPE LIKE '30%') OR (CAR_TYPE = 'SUV' AND DURATION_TYPE LIKE '30%'))

# SELECT *
# FROM (
# SELECT C.CAR_ID AS CAR_ID, C.CAR_TYPE AS CAR_TYPE,
# CASE
#     WHEN C.CAR_TYPE = '세단' THEN ROUND(C.DAILY_FEE * 30 * 0.92)
#     ELSE ROUND(C.DAILY_FEE * 30 * 0.95)
# END AS FEE
# FROM CAR C LEFT JOIN HISTORY H ON C.CAR_ID = H.CAR_ID) AS F
# WHERE FEE >= 500000 AND FEE < 2000000
# GROUP BY CAR_ID
# ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;

# # 세단 8%
# # SUV 5%
# # 1. 세단 or SUV
# # 2. 2022.11.01 ~ 2022.11.30 대여 가능해야 함.
# # 3. 대여 금액이 50만원 이상 200만원 미만

# SELECT *
# FROM CAR C LEFT JOIN HISTORY H ON C.CAR_ID = H.CAR_ID
# WHERE HISTORY_ID IS NULL
SELECT c.car_id, c.car_type,
       ROUND(c.daily_fee * 30 * (100 - p.discount_rate)/100) fee
FROM CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
WHERE c.car_type = p.car_type
      AND p.duration_type = '30일 이상'
      AND c.car_type IN ('세단', 'SUV')
      AND c.car_id NOT IN (SELECT car_id
                           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                           WHERE end_date >= '2022-11-01' 
                                 AND start_date <= '2022-11-30')
      AND ROUND(c.daily_fee * 30 * (100 - p.discount_rate)/100) >= 500000
      AND ROUND(c.daily_fee * 30 * (100 - p.discount_rate)/100) < 2000000
ORDER BY fee DESC, c.car_type, c.car_id DESC;