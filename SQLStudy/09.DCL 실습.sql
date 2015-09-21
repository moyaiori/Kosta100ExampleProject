/*
 * #1. DBA ����(sys, system)���� ���� �� User ����
 */
CREATE USER bangry identified BY bangry;

/*
 * #2.���� �ο�
 * - �ý��� ����
 * - ��ü(���̺�, ���..) ����
 */
-- �ý��� ���� �ο�
GRANT CREATE SESSION TO bangry;

-- ��ü ���� �ο�
--sys�� hr��Ű���� ��ü ������  killer���� �ο�..
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/*
 * #3.���� ȸ��
 */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;

/*
 * #4.������ ��ųʸ��κ��� ���� ��ȸ
 */
 /*�ο��� ����*/
SELECT * FROM  user_tab_privs_recd;

/*�ο��� ����*/
SELECT * FROM user_tab_privs_made;



/*
 * ��(ROLE) : ���� ���ѵ��� ����
 * - �����Ǿ� �ִ� ��(connect, resource ��)
 * - ����� ���� ��
 */
-- #1. ���� ������ �ο�
GRANT CONNECT, RESOURCE TO bangry;

-- #2.����� ���� �� ����
CREATE ROLE my_role;

--DROP ROLE my_role;

-- #3.Ư�� ������ �ѿ� ���
GRANT CREATE SESSION TO my_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO  my_role;

-- cf)��� ������ �ѿ� �ο�
GRANT ALL ON hr.employees TO my_role;

-- #4.������ �� �ο�
--GRANT CONNECT, RESOURCE TO killer;
GRANT my_role TO bangry;

--#5.���� ��� �� ����
ALTER USER killer ACCOUNT LOCK;
ALTER USER killer ACCOUNT UNLOCK;

--#6.���� ��й�ȣ ����
ALTER USER killer IDENTIFIED BY killer;

--#7. ���� ����
DROP USER bangry CASCADE;

--#8. ������ ��ųʸ��κ��� ���� ����Ʈ ��ȸ
SELECT * FROM dba_users;

SELECT *
FROM hr.employees;

CREATE SYNONYM hremp
FOR hr.employees;

SELECT *
FROM hremp;









