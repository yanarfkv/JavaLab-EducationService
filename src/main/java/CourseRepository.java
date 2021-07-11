import models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    Optional<Course> findById(Integer id);
    List<Course> findByName(String name);
    void save(Course course);
    void update(Course course);

}
