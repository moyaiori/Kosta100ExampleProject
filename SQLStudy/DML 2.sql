savePoint sp1;

insert into departments(department_id, department_name)
values(500, 'Hul~~');

savePoint sp2;

update departments
set department_name = 'Çæ'
where department_id = '500';

select *
from departments;

rollback to sp2;

commit;5



create table sample(
        id number(8),
        name varchar2(10)
);

desc sample;

drop table sample;

select *
from user_tables;

select *
from user_constraints;