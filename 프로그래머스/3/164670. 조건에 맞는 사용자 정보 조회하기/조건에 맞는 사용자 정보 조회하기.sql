-- 코드를 입력하세요
SELECT DISTINCT B.WRITER_ID AS USER_ID
     , U.NICKNAME
     , (U.CITY || ' ' || U.STREET_ADDRESS1 || ' ' || U.STREET_ADDRESS2) AS 	전체주소
     , SUBSTR(U.TLNO,0,3) || '-' || SUBSTR(U.TLNO,4,4) || '-' ||  SUBSTR(U.TLNO,8,4) AS 전화번호
FROM USED_GOODS_BOARD B, 
     USED_GOODS_USER U 
WHERE B.WRITER_ID = U.USER_ID
  AND WRITER_ID IN (SELECT WRITER_ID
                FROM (SELECT WRITER_ID
                           , COUNT(WRITER_ID) AS CNT
                        FROM USED_GOODS_BOARD B, 
                             USED_GOODS_USER U 
                       WHERE B.WRITER_ID = U.USER_ID
                       GROUP BY (WRITER_ID)
                     ) A
               WHERE CNT >= 3 )
 ORDER BY WRITER_ID DESC
 ;