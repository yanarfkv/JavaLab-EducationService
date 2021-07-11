package models;

import java.util.List;
import java.util.StringJoiner;

public class Course {
    private Integer id;
    private String name;
    private String date;
    private List<Teacher> teachers;
    private List<Student> students;

    public Course(Integer id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Course(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Course(Integer id, String name, String date, List<Teacher> teachers, List<Student> students) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.teachers = teachers;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name=" + name)
                .add("date=" + date)
                .add("teachers=" + teachers)
                .add("students=" + students)
                .toString();
    }
}

