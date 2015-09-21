/* DML */
-- INSERT
insert into departments(department_id, department_name, manager_id, location_id)
values(501, 'Education2', 100, 1000);

-- ����� NULL �Է�
insert into departments(department_id, department_name, manager_id, location_id)
values(502, 'Education3', NULL, NULL);


-- ������ NULL �Է�
insert into departments(department_id, department_name)
values(503, 'Education4');

-- ���� ������ Ȱ���� �μ���ȣ �ڵ� ����
insert into departments(department_id, department_name)
values((
    select max(department_id) + 10
    from departments)
    , 'Education');


select *
from departments;

-- ���̺� ������ ����
create table dept
as select *
from departments
where 0 = 1;

-- �ູ��
insert into dept
select   *
from departments;

select *
from departments
where department_id >= 500;

--update
update departments
set department_name = 'Kosta Education'
where department_id >= 500;

--delete
delete from departments
where department_id >= 280;

ROLLBACK;