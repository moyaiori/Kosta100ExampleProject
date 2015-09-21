select employee_id, last_name, salary, hire_date
from employees
WHERE salary = (SELECT salary
                            FROM employees
                            WHERE last_name = 'Abel')
                             AND last_name != 'Abel';
                            
-- ������  ��������
-- IN ������ Ȱ��
-- 10�� �μ��� �Ҽӵ� �������  ������ ������ ������ ������ �������Ʈ

SELECT employee_id, last_name, job_id
FROM employees
WHERE job_id IN (SELECT job_id
                    FROM employees
                    WHERE department_id=30);
                   
 -- ANY ������
-- 30�� �μ��� �ּұ޿�(950)�� ���� ���� �޿��� �޴� �������Ʈ
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > ANY(SELECT salary
                              FROM employees
                              WHERE department_id = 30);
  
-- ���������� ����
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT min(salary)
                              FROM employees
                              WHERE department_id = 30);
  
                 -- ALL ������
-- 30�� �μ��� �ִ�޿�(2850)���� ���� �޿��� �޴� �������Ʈ
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > ALL(SELECT salary
                             FROM employees
                             WHERE department_id = 30);
                             
-- 30�� �μ��� �ִ�޿�(2850)���� ���� �޿��� �޴� �������Ʈ
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT max(salary)
                             FROM employees
                             WHERE department_id = 30);

-- EXISTS ������
-- ���������� ����� �ִ���, ������ �Ǻ� ��
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE EXISTS (SELECT *
                         FROM departments
                         WHERE department_id = 70);
   
-- ���� �÷� ��������
-- �μ��� �ּұ޿� ���
SELECT department_id, salary
FROM employees
WHERE (salary, department_id) IN(SELECT min(salary), department_id
                                         FROM employees
                                         GROUP BY employee_id)
ORDER BY department_id;
