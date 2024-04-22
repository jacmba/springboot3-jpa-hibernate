package net.jazbelt.springboot3jpahibernate;

import net.jazbelt.springboot3jpahibernate.jdbc.CourseJdbcRepository;
import net.jazbelt.springboot3jpahibernate.jpa.CourseJpaRepository;
import net.jazbelt.springboot3jpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository jdbcRepository;
    private final CourseJpaRepository jpaRepository;

    @Autowired
    public CourseCommandLineRunner(CourseJdbcRepository repository, CourseJpaRepository jpaRepository) {
        super();
        this.jdbcRepository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running!!");

        jpaRepository.insert(new Course(1, "Learn Spring", "John Doe"));
        jpaRepository.insert(new Course(2, "Learn React", "John Doe"));
        jpaRepository.insert(new Course(3, "Learn AI", "John Doe"));
        jpaRepository.insert(new Course(4, "Learn AWS", "John Doe"));

        jpaRepository.deleteById(1L);

        Course result = jpaRepository.findById(2L);
        System.out.println(result);
    }
}
