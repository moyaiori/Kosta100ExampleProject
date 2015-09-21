-- 하나의 사원은 27개의 부서에 소속될 수 있다(107*27=2889)
SELECT first_name, department_name
FROM employees, departments;

-- 컬럼명의 모호성을 해결하기 위해 테이블명이나 별칭 사용을 권장
SELECT employees.first_name, departments.department_name
FROM employees, departments;

--주로 사용하는 방법, 별칭을 1글자로 써준다.
-- 오라클 조인
SELECT e.first_name, d.department_name
FROM employees e, departments d;

-- DBMS간의 호환을 위해 ANSI(미국규격협회)에서 제시한 표준 CROSS JOIN 구문
-- 오라클 9i부터 지원, 표준 조인
SELECT e.first_name, d.department_name
FROM employees e CROSS JOIN departments d;

-- 크로스 조인(위로)
--인어 조인(아래로)

-- 조인하고자 하는 두 테이블에서 공통적으로 존재하는 컬럼(department_id)의 값을 비교하여
-- 일치하는 행과 행을 연결하여 조인
SELECT e.first_name, d.department_name
FROM employees e, departments d
--조인조건(동등비교)  : Equi Join
WHERE e.department_id = d.department_id;

-- WHERE절에 AND 연산자를 추가하여 검색 조건 추가
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
-- 기타 검색 조건 추가
	AND  e.first_name = 'James';

-- ANSI 표준 INNER JOIN 구문
SELECT e.first_name, d.department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;
--USING(department_id);
--WHERE e.first_name = 'James';

-- Non-Equi Join
-- 공통컬럼이 없는 테이블과 테이블간 조인
-- 조인 조건에서 ‘=’ 연산자를 이용한 동등비교가 아닌 다른 비교연산자를 사용하여 특정범위로 행과 행을 연결하여 조인
-- 사원 급여에 따른 급여등급 출력
-- 현재 XE버전에서는 salgrade 테이블이 없어서 테스트불가
SELECT e.ename, e.sal, s.grade
     FROM emp e, salgrade s
     WHERE e.sal BETWEEN s.losal AND s.hisal;
    
-- XE 버전 Non - Equi Join
-- Oracle join
select e.employee_id, e.last_name, J.JOB_TITLE
from employees e, jobs j
where e.salary between J.MIN_SALARY and J.MAX_SALARY;
     
-- ANSI 표준 INNER JOIN 구문
SELECT e.ename, e.sal, s.grade
FROM emp e JOIN salgrade s
ON e.sal  BETWEEN s.losal AND s.hisal;


-- employees 테이블에에서 부서번호가 NULL 인 Kimberely는 
-- EQUI Join만으로는 검색되지 않음
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- OUTER JOIN 필요
-- 부서번호가 없는 사원도 출력!
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- ANSI 표준 OUTER JOIN 구문(LEFT, RIGHT, FULL 예약어 사용)
--  LEFT OUTER JOIN
SELECT e.first_name, d.department_name
FROM employees e  LEFT OUTER  JOIN  departments d
ON e.department_id = d.department_id;

-- RIGHT OUTER JOIN
SELECT e.first_name, d.department_name
FROM employees e  RIGHT OUTER  JOIN  departments d
ON e.department_id = d.department_id;

-- FULL OUTER JOIN
SELECT e.first_name, d.department_name
FROM employees e FULL OUTER JOIN departments d
on e.department_id = d.department_id;

-- self Join
-- 사원별 상사 검색
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee,EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

-- 상사가 없는 사원도 검색 시 OUTER JOIN 필요
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee LEFT OUTER JOIN EMPLOYEES manager
ON employee.manager_id = manager.employee_id(+);
