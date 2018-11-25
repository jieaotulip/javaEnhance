create database school;

use school;

create table student
(
    studentId int primary key auto_increment not null,
    studentName varchar(10) not null,
    studentAge int,
    studentPhone varchar(15)
) engine=InnoDB, charset=utf8

insert into student values(null,'Betty', '20', '00000000');
insert into student values(null,'Jerry', '18', '11111111');
insert into student values(null,'Betty', '21', '22222222');
insert into student values(null,'Steve', '27', '33333333');
insert into student values(null,'James', '22', '44444444');
commit;