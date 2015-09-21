/* DDL(Data Definition Language) */

-- 테이블 삭제
DROP TABLE person;

/* 테이블 생성 시 컬럼 레벨의 제약조건 추가 */
CREATE TABLE person(
  name     VARCHAR2(10) CONSTRAINT person_name_nn NOT NULL,
  age      NUMBER(10)   NOT NULL,
  birthday DATE         NOT NULL
);

-- 딕셔너리 테이블로부터 제약사항 조회
SELECT *
FROM user_constraints
WHERE table_name = 'PERSON';

-- 1.NOT NULL
CREATE TABLE person(
  	name     VARCHAR2(10) CONSTRAINT person_name_nn NOT NULL,
    age      NUMBER(3)    NOT NULL,
    birthday DATE
);

-- 2.UNIQUE
CREATE TABLE person(
	name     VARCHAR2(10) CONSTRAINT person_name_uk UNIQUE,
	age      NUMBER(3)    NOT NULL,
    birthday DATE
);

-- 3.PRIMARY KEY(UNIQUE + NOT NULL)
CREATE TABLE person(
	name     VARCHAR2(10) CONSTRAINT person_name_pk PRIMARY KEY,
	age      NUBER(3)     NOT NULL,
  birthday DATE
);

-- 4.FOREIGN KEY
CREATE TABLE person(
	name       VARCHAR2(10) CONSTRAINT person_name_pk PRIMARY KEY,
  age        NUMBER(3)    NOT NULL,
  manager_id NUMBER(6) CONSTRAINT person_id_fk
                       REFERENCES employees(employee_id),
  birthday   DATE
);

-- 5.CHECK
CREATE TABLE person(
	name       VARCHAR2(10) CONSTRAINT person_name_pk PRIMARY KEY,
  age        NUMBER(3)    CONSTRAINT person_age_ck CHECK (age BETWEEN 20 AND 100),
  manager_id NUMBER(6)    CONSTRAINT person_id_fk
                          REFERENCES employees(employee_id),
    birthday date
);

CREATE TABLE sawon(
	ssn         NUMBER(10)      CONSTRAINT sawon_ssn_pk PRIMARY KEY,
	name        VARCHAR2(10)    NOT NULL,
  hiredate    DATE            DEFAULT SYSDATE NOT NULL,
  manager_ssn NUMBER(20)      CONSTRAINT sawon_ssn_fk REFERENCES sawon(ssn),
  sex         CHAR(1)         CONSTRAINT sawon_sex_ck CHECK (sex IN('M', 'F') )
);

insert into sawon(ssn, name, manager_ssn, sex)
values(101, '홍길동',to_Date('2015-08-23', 'yyyy-MM-DD'),  null, 'M');

commit;

select *
from sawon;

SELECT *
FROM user_constraints
WHERE table_name = 'PERSON';


/* 테이블 생성 시 제약조건 분리 */
CREATE TABLE person(
  name       VARCHAR2(10),
  age        NUMBER(3)  NOT NULL,
  manager_id NUMBER(6)  NOT NULL,
  birthday   DATE DEFAULT sysdate,
  CONSTRAINT person_name_pk PRIMARY KEY(name),
  CONSTRAINT person_age_ck CHECK (age BETWEEN 20 AND 30),
  CONSTRAINT person_id_fk FOREIGN KEY(manager_id)
                         REFERENCES EMPLOYEES(employee_id)
);

DROP TABLE person;


/* 테이블 생성 후 테이블 변경을 통한 제약조건 추가(권장) */
CREATE TABLE person(
  name       VARCHAR2(10),
  age        NUMBER(3)  NOT NULL,
  manager_id NUMBER(6)  NOT NULL,
  birthday   DATE DEFAULT sysdate
);

-- 생성된  테이블에 제약조건 추가
ALTER TABLE person
	ADD ( CONSTRAINT person_name_pk PRIMARY KEY(name),
        CONSTRAINT person_age_ck CHECK (age BETWEEN 20 AND 30),
        CONSTRAINT person_id_fk FOREIGN KEY(manager_id)
                         REFERENCES EMPLOYEES(employee_id));

-- 개발의 편의를 위한 제약조건 활성화/비활성화
ALTER TABLE person
	DISABLE CONSTRAINT person_name_pk CASCADE
    DISABLE CONSTRAINT person_age_ck
    DISABLE CONSTRAINT person_id_fk;

ALTER TABLE person
	ENABLE CONSTRAINT person_name_pk
    ENABLE CONSTRAINT person_age_ck
    ENABLE CONSTRAINT person_id_fk;

-- 테스트를 위한 인서트
INSERT INTO person(NAME, age, manager_id)
VALUES ('김기정', 25, 100);

INSERT INTO person(NAME, age, manager_id, birthday)
VALUES ('김기장', 30, 100, TO_DATE('1968-03-13', 'YYYY-MM-DD'));

COMMIT;

SELECT *
FROM person;

--제약조건 삭제
ALTER TABLE person
	DROP CONSTRAINT person_age_ck CASCADE;

DESC person;

-- 테이블 구조 변경
--1.컬럼 추가
ALTER TABLE person
	ADD (address VARCHAR2(100));
--2.컬럼 수정
ALTER TABLE person
	MODIFY (address VARCHAR2(200));
--3.컬럼 삭제
ALTER TABLE person
	drop COLUMN address;

-- 서브쿼리를 이용한 테이블 생성(복사)
CREATE TABLE emp_info
	AS
    SELECT department_id "부서번호", COUNT(*) "사원수", SUM(salary) "급여총합", ROUND(AVG(salary)) "급여평균", MIN(salary) "최소급여", MAX(salary) "최대급여"
    FROM EMPLOYEES
    GROUP BY department_id
    ORDER BY department_id;

SELECT * FROM emp_info;

/* RENAME : 테이블 이름 변경 */
RENAME sometable TO sometable2;

/* TRUNCATE */
-- 저장공간 해제
-- DML의 DELETE와 달리 삭제된 행은 복구 할수 없다(Auto Commit)
-- INDEX가 있을 경우 다시 생성해야 한다.
TRUNCATE table dept ;

/* DROP : 테이블 삭제 */
-- 테이블의 모든 구조와 자료, 제약사항이 삭제되며
-- 그와 연관된 INDEX 도 삭제된다.
DROP table person;

-- 테이블과 관련된  제약사항도 삭제
DROP table person CASCADE CONSTRAINTS;