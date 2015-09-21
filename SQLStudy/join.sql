-- �ϳ��� ����� 27���� �μ��� �Ҽӵ� �� �ִ�(107*27=2889)
SELECT first_name, department_name
FROM employees, departments;

-- �÷����� ��ȣ���� �ذ��ϱ� ���� ���̺���̳� ��Ī ����� ����
SELECT employees.first_name, departments.department_name
FROM employees, departments;

--�ַ� ����ϴ� ���, ��Ī�� 1���ڷ� ���ش�.
-- ����Ŭ ����
SELECT e.first_name, d.department_name
FROM employees e, departments d;

-- DBMS���� ȣȯ�� ���� ANSI(�̱��԰���ȸ)���� ������ ǥ�� CROSS JOIN ����
-- ����Ŭ 9i���� ����, ǥ�� ����
SELECT e.first_name, d.department_name
FROM employees e CROSS JOIN departments d;

-- ũ�ν� ����(����)
--�ξ� ����(�Ʒ���)

-- �����ϰ��� �ϴ� �� ���̺��� ���������� �����ϴ� �÷�(department_id)�� ���� ���Ͽ�
-- ��ġ�ϴ� ��� ���� �����Ͽ� ����
SELECT e.first_name, d.department_name
FROM employees e, departments d
--��������(�����)  : Equi Join
WHERE e.department_id = d.department_id;

-- WHERE���� AND �����ڸ� �߰��Ͽ� �˻� ���� �߰�
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
-- ��Ÿ �˻� ���� �߰�
	AND  e.first_name = 'James';

-- ANSI ǥ�� INNER JOIN ����
SELECT e.first_name, d.department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;
--USING(department_id);
--WHERE e.first_name = 'James';

-- Non-Equi Join
-- �����÷��� ���� ���̺�� ���̺� ����
-- ���� ���ǿ��� ��=�� �����ڸ� �̿��� ����񱳰� �ƴ� �ٸ� �񱳿����ڸ� ����Ͽ� Ư�������� ��� ���� �����Ͽ� ����
-- ��� �޿��� ���� �޿���� ���
-- ���� XE���������� salgrade ���̺��� ��� �׽�Ʈ�Ұ�
SELECT e.ename, e.sal, s.grade
     FROM emp e, salgrade s
     WHERE e.sal BETWEEN s.losal AND s.hisal;
    
-- XE ���� Non - Equi Join
-- Oracle join
select e.employee_id, e.last_name, J.JOB_TITLE
from employees e, jobs j
where e.salary between J.MIN_SALARY and J.MAX_SALARY;
     
-- ANSI ǥ�� INNER JOIN ����
SELECT e.ename, e.sal, s.grade
FROM emp e JOIN salgrade s
ON e.sal  BETWEEN s.losal AND s.hisal;


-- employees ���̺����� �μ���ȣ�� NULL �� Kimberely�� 
-- EQUI Join�����δ� �˻����� ����
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- OUTER JOIN �ʿ�
-- �μ���ȣ�� ���� ����� ���!
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- ANSI ǥ�� OUTER JOIN ����(LEFT, RIGHT, FULL ����� ���)
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
-- ����� ��� �˻�
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee,EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

-- ��簡 ���� ����� �˻� �� OUTER JOIN �ʿ�
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee LEFT OUTER JOIN EMPLOYEES manager
ON employee.manager_id = manager.employee_id(+);
