-- create table
create table student(
	student_id INT PRIMARY KEY, 
	name varchar(100) NOT NULL,
	major varchar(50) UNIQUE
);

--describing the table 
desc student;

--adding column:
alter table student add gpa decimal (3, 2);
--removing column: 
alter table student drop column gpa;

--inserting data into table:
insert into student values(1, 'jack', 'biology');
--inserting into few columns: 
insert into student(student_id, name) values (2, 'akash');
--inserting multiple entries into table: 
insert into student values(3, 'john', 'science'), (4, 'harry potter', 'magic');

--displaying table data: 
select *from student;

 
