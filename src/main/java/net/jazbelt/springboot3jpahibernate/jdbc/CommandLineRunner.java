package net.jazbelt.springboot3jpahibernate.jdbc;

import net.jazbelt.springboot3jpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final CourseJdbcRepository repository;

    @Autowired
    public CommandLineRunner(CourseJdbcRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running!!");

        repository.insert(new Course(1, "Learn Spring", "John Doe"));
        repository.insert(new Course(2, "Learn React", "John Doe"));
        repository.insert(new Course(3, "Learn AI", "John Doe"));
        repository.insert(new Course(4, "Learn AWS", "John Doe"));

        repository.deleteById(1L);

        Course result = repository.findById(2L);
        System.out.println(result);
    }
}
