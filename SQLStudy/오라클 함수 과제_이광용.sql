--1. �޿��� 5000�̻� 15000���� ���̿� ���Ե��� �ʴ� ����� �����ȣ(employee_id), �̸�(last_name), �޿�(salary), �Ի�����(hire_date)�� ��ȸ�϶�.
select employee_id, last_name, salary, hire_date
from employees
--where NOT (salary > 5000 AND salary < 15000);
where NOT (salary BETWEEN 5000 AND 15000);

select *
from employees;

--2. �μ���ȣ(department_id)�� 50�̰�, ����(job_id)�� 'ST_MAN'�̰�, 
--   �Ի����� 2004�� 7�� 18���� ����� �����ȣ, �̸�, ����, �Ի����� ��ȸ�϶�.
select department_id, last_name, job_id, hire_date
from employees
where department_id = 50 
    AND job_id = 'ST_MAN' 
    AND hire_date = '2004/07/18';

--3. 2002�� ���� �Ի����߿��� ������(ST_MAN, ST_CLERK)�� ����ϴ� ������� ��� ����(�÷�)�� ��ȸ�϶�.
select *
from employees
where job_id = 'ST_MAN' OR job_id = 'ST_CLERK'
    AND hire_date >= '2002/01/01';
-- in�� �̿��Ͽ� �ϱ�

--4. ���(manager_id)�� ���� ����� ��� ����(�÷�)�� ��ȸ�϶�.
select *
from employees
where manager_id is NULL;

--5. �޿��� 10000 �̸��� ����߿��� ���(SH_CLERK)�̳� ����(PU_MAN, PU_CLERK)������ ����ϴ� ������� ��� ������ ��ȸ�϶�.
select *
from employees
where salary < 10000 AND (job_id = ' SH_CLERK' OR job_id = 'PU_MAN' OR job_id = 'PU_CLERK');
-- in Ȱ���Ͽ� �ϱ�

--6. ����� �̸�(first_name)�� 'S'�� ���Ե� ����� ��� ������ ����϶�.
select *
from employees
where  first_name LIKE '%S%';

--7. �⵵�� �Ի��ο����� ��ȸ�϶�. 01 ~ 08
-- �Ի�⵵, ī��Ʈ
SELECT TO_CHAR(hire_date, 'YYYY') year, COUNT(*) count
FROM employees
GROUP BY hire_date
ORDER BY year;

--8. �����ȣ(employee_id)�� Ȧ���� ����� ��� ������ ��ȸ�϶�.
-- MOD�� Ȱ���Ͽ� ������ �� 
SELECT *
FROM employees
WHERE MOD(employee_id, 2) = 1;


--9.���ú��� 6���� �� ���ƿ��� ù��° �ݿ��� ��¥�� ����϶�.
--   (��¥ ���� ��: 2002-06-05 15:23:10), 6������ ������ �űⰪ���� �ݿ����� ������ ���� ���˿� ���缭 �ٲ�
SELECT TO_CHAR(NEXT_DAY(ADD_MONTHS(SYSDATE, 6), 6), 'YYYY-MM-DD HH24:MI:SS DAY')
FROM dual;


--10.�����ȣ(employee_id), �����(first_name), ����ȣ(manager_id)�� ����ϵ�
--   ����ȣ�� ����(NULL) ��� ����ȣ�� '�뻧'�̶� ����϶�.
--select employee_id, first_name, manager_id
-- NVL�� Ȱ���Ͽ�  null���� ��� '�뻧'���� ����
SELECT employee_id, first_name, NVL(TO_CHAR(manager_id),'�뻧')
from employees;

--11.������� 3���౸������ �з��ϱ� ���� ����� 3���� ������
--   �������� 0�̸� "��ȭ�����"
--   �������� 1�̸� "���׸���"
--   �������� 2�̸� "������"���� �з��Ͽ� ���̸�, �����ȣ, ������� ����϶�.
-- DECODE�� Ȱ��, MOD ������, ����� 3���� ���� ������ DECODE�� Ȱ���Ͽ� 0,1,2�� ���� ���� �ο�
SELECT employee_id, first_name,DECODE(MOD(employee_id, 3), 0, '��ȭ�����',
                                                           1, '���׸���',
                                                           2, '������') team
FROM employees
ORDER BY team;

--12.����� �޿��׷����� �Ʒ��� ���� ����϶�.
--   Steven King     *****($5,000) // $1000�޷��� �� 1���߰�.
--   Neena Kochhar  ***($3,000)--    .........
--   XXXX XXXXX    *****************($17,000)
-- �������� ä��� �������� ����, �޿� 1000���� "*" 1���� ���, �ϳ��� �����ؼ� +1, 
SELECT RPAD(first_name || ' ' || last_name, 20, ' ') "�̸�" , RPAD(' ', (salary / 1000)+1 , '*') || '('||  TO_CHAR(salary, '$99,999') || ')' "�޿��׷���"
FROM employees
ORDER BY salary DESC;

--13.2002�� 3������ 2003�� 2�� �Ⱓ ���� �Ի��� ����� ������� �μ��� �ο����� ��ȸ�϶�.
--   ����� �ο����� ���� ������� �����Ͽ� ��ȸ
-- 2002-03 ~ 2003-03 ���̿� ���߿�  department_id �׷쿡�� ���� ������ ���
SELECT department_id, COUNT(*)
FROM employees
WHERE hire_date BETWEEN TO_DATE('2002-03', 'YYYY-MM') AND TO_DATE('2003-03', 'YYYY-MM')
GROUP BY department_id
ORDER BY COUNT(*) DESC;

--14.������ ��� �޿��� ����϶�. ��, ��ձ޿��� 10000�� �ʰ��ϴ� ���� �����ϰ� ��� �޿��� ���� �������� �����Ѵ�.
-- ������, ��ձ޿� �� �˻��Ѵ�, �� �������� �׷��� ���Ŀ� �� �ȿ��� ��հ��� 10000������ �ֵ� �� ��ձ޿� �������� ���� �Ѵ�.
SELECT job_id, AVG(salary) avg
FROM employees
GROUP BY job_id
HAVING AVG(salary) <= 10000
ORDER BY avg;

--15.2002�⿡ �Ի��� ������� ������κ��� �б⺰ �Ի����� ���� ��ȸ�϶�.
--�б�   �����
---------------
--1      3
--2      1
--3      2
--4      0
-- Q�� �б⸦ ��Ÿ����. 1/4�б⿡�� �Ի��ڰ� ����. 2002�⵵ �� �б⿡ �ش�Ǵ� ����� ī��Ʈ �Ѵ�.
SELECT TO_CHAR(hire_date, 'Q') �б�, COUNT(employee_id) �����
FROM EMPLOYEES
WHERE TO_CHAR(hire_date, 'YYYY') = '2002'
GROUP BY TO_CHAR(hire_date, 'Q')
ORDER BY �б�;