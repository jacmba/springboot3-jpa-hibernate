package net.jazbelt.springboot3jpahibernate.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import net.jazbelt.springboot3jpahibernate.model.Course;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager manager;

    public void insert(Course course) {
        manager.merge(course);
    }

    public Course findById(long id) {
        return manager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course result = findById(id);
        manager.remove(result);
    }
}
