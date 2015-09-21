/* 오라클 함수 */

-- 1. 단일행 함수
-- 문자열 처리와 관련된 함수
select concat('바보', last_name)
from employees;

DESC dual;

select 10 * 20
from dual;

select *
from dual;

SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;

SELECT INITCAP('kim ki jung')
FROM dual;

SELECT first_name, last_name
FROM employees
WHERE lower(first_name) = 'james';

SELECT LPAD('DataBase', 10, '*')
FROM dual;

-- 1부터 시작(java는 0부터 시작)
SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE('Jack and Jue', 'J', 'Bl')
FROM dual;

--SELECT INSTR('DataBase', 'B')
SELECT INSTR('DataBase', 'a', 1, 2)
FROM dual;

SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT TRIM('1' from '111Java Developer1111')
SELECT TRIM('    Java Developer     ')
FROM dual;