/* DML */
-- INSERT
insert into departments(department_id, department_name, manager_id, location_id)
values(501, 'Education2', 100, 1000);

-- 명시적 NULL 입력
insert into departments(department_id, department_name, manager_id, location_id)
values(502, 'Education3', NULL, NULL);


-- 묵시적 NULL 입력
insert into departments(department_id, department_name)
values(503, 'Education4');

-- 서브 쿼리를 활용한 부서번호 자동 증가
insert into departments(department_id, department_name)
values((
    select max(department_id) + 10
    from departments)
    , 'Education');


select *
from departments;

-- 테이블 구조만 복사
create table dept
as select *
from departments
where 0 = 1;

-- 행복사
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