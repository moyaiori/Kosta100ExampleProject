/*
 * #1. DBA 계정(sys, system)으로 연결 후 User 생성
 */
CREATE USER bangry identified BY bangry;

/*
 * #2.권한 부여
 * - 시스템 권한
 * - 객체(테이블, 뷰등..) 권한
 */
-- 시스템 권한 부여
GRANT CREATE SESSION TO bangry;

-- 객체 권한 부여
--sys가 hr스키마의 객체 권한을  killer에게 부여..
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/*
 * #3.권한 회수
 */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;

/*
 * #4.데이터 딕셔너리로부터 권한 조회
 */
 /*부여된 권한*/
SELECT * FROM  user_tab_privs_recd;

/*부여한 권한*/
SELECT * FROM user_tab_privs_made;



/*
 * 롤(ROLE) : 여러 권한들의 묶음
 * - 생성되어 있는 롤(connect, resource 등)
 * - 사용자 정의 롤
 */
-- #1. 롤을 유저에 부여
GRANT CONNECT, RESOURCE TO bangry;

-- #2.사용자 정의 롤 생성
CREATE ROLE my_role;

--DROP ROLE my_role;

-- #3.특정 권한을 롤에 등록
GRANT CREATE SESSION TO my_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO  my_role;

-- cf)모든 권한을 롤에 부여
GRANT ALL ON hr.employees TO my_role;

-- #4.유저에 롤 부여
--GRANT CONNECT, RESOURCE TO killer;
GRANT my_role TO bangry;

--#5.유저 잠금 및 해제
ALTER USER killer ACCOUNT LOCK;
ALTER USER killer ACCOUNT UNLOCK;

--#6.유저 비밀번호 변경
ALTER USER killer IDENTIFIED BY killer;

--#7. 유저 삭제
DROP USER bangry CASCADE;

--#8. 데이터 딕셔너리로부터 유저 리스트 조회
SELECT * FROM dba_users;

SELECT *
FROM hr.employees;

CREATE SYNONYM hremp
FOR hr.employees;

SELECT *
FROM hremp;









