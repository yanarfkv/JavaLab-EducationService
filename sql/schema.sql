create table teacher
(
    id serial primary key,
    first_name varchar(20),
    last_name varchar(20),
    experience integer
);

create table course
(
    id serial primary key,
    name varchar(30),
    date varchar (30),
    teacher_id integer,
    foreign key (teacher_id) references teacher (id)
);

create table lesson
(
    id serial primary key,
    name varchar(30),
    time varchar(30),
    course_id integer,
    foreign key (course_id) references course (id)
);

create table teacher_course
(
    teacher_id integer,
    course_id integer,
    foreign key (teacher_id) references teacher (id),
    foreign key (course_id) references course (id)
);

create table student
(
    id serial primary key,
    first_name varchar(20),
    last_name varchar(20),
    study_group integer
);

create table student_course
(
    course_id integer,
    student_id integer,
    foreign key (course_id) references course (id),
    foreign key (student_id) references student (id)
);