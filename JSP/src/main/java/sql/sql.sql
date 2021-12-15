select * from DEPARTMENTS;

select * from jdbc_member;

create table jdbc_member
(id varchar2(50),
pw varchar2(50) not null,
nickname varchar2(50),
constraint jdbc_id_pk primary key (id)
);

insert into jdbc_member
values ('smhrd','1234','smhrd');
-- 실행할 부분을 드래그하고 블록지정후 ALT + X

drop table jdbc_member;




