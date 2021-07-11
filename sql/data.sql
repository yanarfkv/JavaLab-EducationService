insert into teacher (first_name, last_name, experience)
values ('Марсель', 'Сидиков', 10);
insert into teacher (first_name, last_name, experience)
values ('Михаил', 'Абрамский', 10);
insert into teacher (first_name, last_name, experience)
values ('Елена', 'Широкова', 20);
insert into teacher (first_name, last_name, experience)
values ('Николай', 'Петров', 20);

insert into course (name, date, teacher_id)
values ('Математика', '01.09.2020/31.05.2021', 3);
insert into course (name, date, teacher_id)
values ('Практика JavaLab', '25.06.2021/12.07.2021', 1);
insert into course (name, date, teacher_id)
values ('Русский язык', '21.01.2021/20.02.2022', 4);
insert into course (name, date, teacher_id)
values ('Информатика', '01.09.2020/31.05.2021', 2);
insert into course (name, date, teacher_id)
values ('Базы данных', '01.09.2020/31.05.2021', 2);

insert into teacher_course (teacher_id, course_id)
values (1, 2);
insert into teacher_course (teacher_id, course_id)
values (2, 4);
insert into teacher_course (teacher_id, course_id)
values (3, 1);
insert into teacher_course (teacher_id, course_id)
values (4, 3);
insert into teacher_course (teacher_id, course_id)
values (2, 5);

insert into student (first_name, last_name, study_group)
values ('Даниил', 'Вдовинов', 3);
insert into student (first_name, last_name, study_group)
values ('Виктор', 'Евлампьев', 2);
insert into student (first_name, last_name, study_group)
values ('Максим', 'Поздеев', 2);
insert into student (first_name, last_name, study_group)
values ('Азат', 'Набиев', 1);
insert into student (first_name, last_name, study_group)
values ('Айрат', 'Мухутдинов', 1);

insert into student_course (course_id, student_id)
values (1, 1);
insert into student_course (course_id, student_id)
values (3, 1);
insert into student_course (course_id, student_id)
values (4, 2);
insert into student_course (course_id, student_id)
values (2, 2);
insert into student_course (course_id, student_id)
values (5, 3);
insert into student_course (course_id, student_id)
values (1, 3);
insert into student_course (course_id, student_id)
values (3, 4);
insert into student_course (course_id, student_id)
values (4, 4);
insert into student_course (course_id, student_id)
values (2, 5);
insert into student_course (course_id, student_id)
values (5, 5);

insert into lesson (name, time, course_id)
values ('JdbcTemplate', 'Понедельник 10:00', 2);
insert into lesson (name, time, course_id)
values ('Maven', 'Вторник 12:00', 2);
insert into lesson (name, time, course_id)
values ('Математический анализ', 'Четверг 15:00', 1);
insert into lesson (name, time, course_id)
values ('Программирование на Java', 'Суббота 11:00', 4);
insert into lesson (name, time, course_id)
values ('Программирование на Python', 'Понедельник 12:00', 4);
insert into lesson (name, time, course_id)
values ('Орфография', 'Понедельник 15:00', 3);
insert into lesson (name, time, course_id)
values ('Database', 'Понедельник 15:00', 5);


