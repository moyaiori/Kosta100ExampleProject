--1. employees(�������), departments(�μ�����), locations(��������) ���̺���
--   ������ 'London'�� ��ġ�� �μ��� �����ȣ(employee_id), ����̸�(first_name), �μ���(department_name), �μ���ġ(city)�� ����϶�.
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

--2. ����̸�(first_name)�� 'A'�� ���Ե� ����� �̸��� �μ����� ����϶�.
select first_name, department_name
from employees e JOIN departments d
ON e.department_id = d.department_id
where first_name LIKE '%A%';


--3. �޿�(salary)�� 3000���� 5000 ������ ����� ��ȣ, �̸�, �޿�, �μ����� ����϶�.
select employee_id, first_name, salary, department_name
from employees e JOIN departments d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
where salary BETWEEN 3000 AND 5000;

--4. 'Accounting' �μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ����϶�.
select first_name, hire_date
from employees e JOIN departments d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
where department_name = 'Accounting';


--5. 'James(first_name)'�� ���� �μ��� �ٹ��ϴ� ����� ��� ��� ������ ����϶�
--    (��. James�� ����)
select *
from employees
where department_id in (select department_id
                            from employees
                            where  first_name = 'James')
                            AND NOT first_name = 'James';


--6. 'Lee(last_name)'���� �ʰ� �Ի��� ����� �̸��� �Ի��� ����϶�.
select last_name, hire_date
from employees
where hire_date > ( select hire_date
                                from employees
                                where last_name = 'Lee');

--7. 'Lee(last_name)'���� ���� �޿��� �޴� ����� �̸��� �޿��� ����϶�.
select first_name, salary
from employees
where salary > ( select salary
                                from employees
                                where last_name = 'Lee');
                                
--8. 50�� �μ��� ������ ���� �޿��� �޴� ����� �̸��� �޿��� ����϶�.
select first_name, salary
from employees
where salary IN ( select salary
                            from employees
                            where department_id = '50');


--9. ��� ����� ��ձ޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿��� ����϶�.
select employee_id, first_name, salary
from employees
where salary > ALL(select AVG(salary) avg
                            from employees );
                            
--10.�̸��� 'T'�� ���ԵǾ� �ִ� ����� ������ �μ��� �ٹ��ϴ� ����� ��ȣ, �̸��� ����϶�.
select employee_id, first_name
from employees
where department_id IN ( select department_id
                                    from employees
                                    where first_name LIKE '%T%');

--11.10�� �μ� �ִ�޿��ڿ� ������ �޿��� �޴� ����� ��ȣ, �̸�, �޿��� ����϶�.
select employee_id, first_name, salary
from employees
where salary = ( select salary
                                    from employees
                                    where department_id = '10'
                                    );
                                    

--12. 10���μ��� �ٹ��ϴ� ����� �̸��� �μ��� ���
select first_name, department_name
from employees e JOIN departments d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
where e.DEPARTMENT_ID = '10';

-- ������� �ϼ�

--13. �μ��� �ִ� �޿��� �޴� ��� ����(�μ��̸�, ����̸�, �޿�)�� ����϶�.
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



--14. ������ 'IT_PROG'�� ����� �ִ� �޿����� ���� �޿��� �޴� ��� ����(�μ���ȣ, �����ȣ, �̸�, �޿�)�� ����϶�.
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE salary > (
    SELECT max(salary)
    FROM employees
    WHERE UPPER(job_id) = 'IT_PROG');

--15. �μ��� ��ձ޿����� ���� �޿��� �޴� �������(�μ���ȣ, �����ȣ, ����̸�, �޿�)�� �μ����� ����϶�SELECT e1.department_id, e1.employee_id, e1.first_name, e1.salary
FROM EMPLOYEES e1 
    JOIN (
        SELECT department_id, AVG(salary) avg_sal
        FROM EMPLOYEES
        GROUP BY department_id) e2
    ON e1.department_id = e2.department_id
WHERE e1.salary > e2.avg_sal
ORDER BY e1.department_id;