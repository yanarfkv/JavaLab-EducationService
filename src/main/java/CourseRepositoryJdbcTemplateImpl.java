import models.Course;
import models.Student;
import models.Teacher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.*;

public class CourseRepositoryJdbcTemplateImpl implements CourseRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into course (name, date, teacher_id) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_FIND_BY_ID = "select * from course where course.id = ?";

    //language=SQL
    private static final String SQL_UPDATE_BY_ID = "update course set name = ?, date = ?, teacher_id = ? where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME = "select * from course where name = ?";

    private final JdbcTemplate jdbcTemplate;

    public CourseRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Course> courseRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        String date = row.getString("date");

        Course course = new Course(id, name, date);

        course.setStudents(new ArrayList<>());
        course.setTeachers(new ArrayList<>());

        return course;
    };

    private final RowMapper<Teacher> teacherRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        Integer experience = row.getInt("experience");

        Teacher teacher = new Teacher(id, firstName, lastName, experience);
        teacher.setCourses(new ArrayList<>());

        return teacher;
    };

    private final RowMapper<Student> studentRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        Integer group = row.getInt("study_group");

        Student student = new Student(id, firstName, lastName, group);
        student.setCourses(new ArrayList<>());

        return student;
    };

    @Override
    public Optional<Course> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, courseRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Course> findByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_BY_NAME, courseRowMapper, name);
    }

    @Override
    public void save(Course course) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[] {"id"});
            statement.setString(1, course.getName());
            statement.setString(2, course.getDate());
            statement.setArray(3, (Array) course.getTeachers());
            return statement;
        }, keyHolder);
        course.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Course course) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, course.getName(), course.getDate(), course.getTeachers(), course.getId());
    }
}
