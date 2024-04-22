package net.jazbelt.springboot3jpahibernate;

import net.jazbelt.springboot3jpahibernate.jdbc.CourseJdbcRepository;
import net.jazbelt.springboot3jpahibernate.jpa.CourseJpaRepository;
import net.jazbelt.springboot3jpahibernate.jpa.CourseSpringDataJpaRepository;
import net.jazbelt.springboot3jpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // private final CourseJdbcRepository repository;
    // private final CourseJpaRepository repository;
    private final CourseSpringDataJpaRepository repository;

    @Autowired
    public CourseCommandLineRunner(CourseSpringDataJpaRepository jpaRepository) {
        super();
        this.repository = jpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running!!");

        repository.save(new Course(1, "Learn Spring", "John Doe"));
        repository.save(new Course(2, "Learn React", "John Doe"));
        repository.save(new Course(3, "Learn AI", "John Doe"));
        repository.save(new Course(4, "Learn AWS", "John Doe"));

        repository.deleteById(1L);

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("John Doe"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS"));
        System.out.println(repository.findByName(""));
    }
}
