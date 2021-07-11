import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.Course;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(properties.getProperty("db.driver"));
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setUsername(properties.getProperty("db.user"));
        config.setPassword(properties.getProperty("db.password"));
        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.pool-size")));

        DataSource dataSource = new HikariDataSource(config);

        CourseRepository courseRepository = new CourseRepositoryJdbcTemplateImpl(dataSource);

        System.out.println(courseRepository.findById(2));

        System.out.println(courseRepository.findByName("Информатика"));

        Course course = new Course("New course", "01.01.2020/01.01.2021");
        courseRepository.save(course);
        System.out.println(course);

        course.setName("New name");
        courseRepository.update(course);

    }
}
