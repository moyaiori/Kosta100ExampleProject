--1. employees(사원정보), departments(부서정보), locations(지역정보) 테이블에서
--   지역이 'London'에 위치한 부서의 사원번호(employee_id), 사원이름(first_name), 부서명(department_name), 부서위치(city)를 출력하라.
--select employee_id, first_name, department_name
select employee_id, first_name, department_name, city
from employees e 
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
where city = 'London';

select *
from locations;

select *
from employees;

select *
from departments;

--2. 사원이름(first_name)에 'A'가 포함된 사원의 이름과 부서명을 출력하라.
select first_name, department_name
from employees e JOIN departments d
ON e.department_id = d.department_id
where first_name LIKE '%A%';


--3. 급여(salary)가 3000에서 5000 사이인 사원의 번호, 이름, 급여, 부서명을 출력하라.
select employee_id, first_name, salary, department_name
from employees e JOIN departments d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
where salary BETWEEN 3000 AND 5000;

--4. 'Accounting' 부서에 근무하는 사원의 이름과 입사일을 출력하라.
select first_name, hire_date
from employees e JOIN departments d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
where department_name = 'Accounting';


--5. 'James(first_name)'와 동일 부서에 근무하는 사원의 모든 모든 정보를 출력하라
--    (단. James은 제외)
select *
from employees
where department_id in (select department_id
                            from employees
                            where  first_name = 'James')
                            AND NOT first_name = 'James';


--6. 'Lee(last_name)'보다 늦게 입사한 사원의 이름과 입사일 출력하라.
select last_name, hire_date
from employees
where hire_date > ( select hire_date
                                from employees
                                where last_name = 'Lee');

--7. 'Lee(last_name)'보다 많은 급여를 받는 사원의 이름과 급여을 출력하라.
select first_name, salary
from employees
where salary > ( select salary
                                from employees
                                where last_name = 'Lee');
                                
--8. 50번 부서의 사원들과 같은 급여를 받는 사원의 이름과 급여를 출력하라.
select first_name, salary
from employees
where salary IN ( select salary
                            from employees
                            where department_id = '50');


--9. 모든 사원의 평균급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여를 출력하라.
select employee_id, first_name, salary
from employees
where salary > ALL(select AVG(salary) avg
                            from employees );
                            
--10.이름에 'T'가 포함되어 있는 사원과 동일한 부서에 근무하는 사원의 번호, 이름을 출력하라.
select employee_id, first_name
from employees
where department_id IN ( select department_id
                                    from employees
                                    where first_name LIKE '%T%');

--11.10번 부서 최대급여자와 동일한 급여를 받는 사원의 번호, 이름, 급여를 출력하라.
select employee_id, first_name, salary
from employees
where salary = ( select salary
                                    from employees
                                    where department_id = '10'
                                    );
                                    

--12. 10번부서에 근무하는 사원의 이름과 부서명 출력
select first_name, department_name
from employees e JOIN departments d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
where e.DEPARTMENT_ID = '10';

-- 여기까지 완성

--13. 부서별 최대 급여를 받는 사원 정보(부서이름, 사원이름, 급여)를 출력하라.
--select department_name, first_name, salary
--from employees e JOIN departments d
--ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
--where salary in ( select 
--
--);

SELECT d.department_name, e.employee_id, e.last_name, e.salary
FROM EMPLOYEES e 
    JOIN departments d
    ON e.department_id = d.department_id
WHERE (e.department_id, e.salary) IN (
    SELECT department_id, MAX(salary)
	FROM EMPLOYEES
    GROUP BY department_id)
ORDER BY d.department_name;



--14. 업무가 'IT_PROG'인 사원의 최대 급여보다 많은 급여를 받는 사원 정보(부서번호, 사원번호, 이름, 급여)를 출력하라.
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE salary > (
    SELECT max(salary)
    FROM employees
    WHERE UPPER(job_id) = 'IT_PROG');

--15. 부서별 평균급여보다 높은 급여를 받는 사원정보(부서번호, 사원번호, 사원이름, 급여)를 부서별로 출력하라SELECT e1.department_id, e1.employee_id, e1.first_name, e1.salary
FROM EMPLOYEES e1 
    JOIN (
        SELECT department_id, AVG(salary) avg_sal
        FROM EMPLOYEES
        GROUP BY department_id) e2
    ON e1.department_id = e2.department_id
WHERE e1.salary > e2.avg_sal
ORDER BY e1.department_id;