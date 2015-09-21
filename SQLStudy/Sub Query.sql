select employee_id, last_name, salary, hire_date
from employees
WHERE salary = (SELECT salary
                            FROM employees
                            WHERE last_name = 'Abel')
                             AND last_name != 'Abel';
                            
-- 다중행  서브쿼리
-- IN 연산자 활용
-- 10번 부서에 소속된 사원들의  업무와 동일한 업무를 가지는 사원리스트

SELECT employee_id, last_name, job_id
FROM employees
WHERE job_id IN (SELECT job_id
                    FROM employees
                    WHERE department_id=30);
                   
 -- ANY 연산자
-- 30번 부서의 최소급여(950)자 보다 많은 급여를 받는 사원리스트
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > ANY(SELECT salary
                              FROM employees
                              WHERE department_id = 30);
  
-- 단일행으로 변경
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT min(salary)
                              FROM employees
                              WHERE department_id = 30);
  
                 -- ALL 연산자
-- 30번 부서의 최대급여(2850)보다 많은 급여를 받는 사원리스트
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > ALL(SELECT salary
                             FROM employees
                             WHERE department_id = 30);
                             
-- 30번 부서의 최대급여(2850)보다 많은 급여를 받는 사원리스트
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT max(salary)
                             FROM employees
                             WHERE department_id = 30);

-- EXISTS 연산자
-- 서브쿼리의 결과가 있느냐, 없느냐 판별 시
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE EXISTS (SELECT *
                         FROM departments
                         WHERE department_id = 70);
   
-- 다중 컬럼 서브쿼리
-- 부서별 최소급여 출력
SELECT department_id, salary
FROM employees
WHERE (salary, department_id) IN(SELECT min(salary), department_id
                                         FROM employees
                                         GROUP BY employee_id)
ORDER BY department_id;
