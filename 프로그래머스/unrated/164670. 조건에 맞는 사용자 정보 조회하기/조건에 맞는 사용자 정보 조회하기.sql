-- 코드를 입력하세요
WITH BOARD AS (SELECT WRITER_ID, COUNT(*) AS COUNT
FROM USED_GOODS_BOARD
GROUP BY WRITER_ID
HAVING COUNT >= 3)

SELECT USER_ID, NICKNAME, CONCAT(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) AS 전체주소, CONCAT(LEFT(TLNO, 3), "-", MID(TLNO, 4, 4), "-", RIGHT(TLNO, 4)) AS 전화번호
FROM USED_GOODS_USER U, BOARD B
WHERE U.USER_ID = B.WRITER_ID
ORDER BY USER_ID DESC;