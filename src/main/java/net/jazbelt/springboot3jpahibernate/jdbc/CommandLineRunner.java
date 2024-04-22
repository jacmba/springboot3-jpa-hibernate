package net.jazbelt.springboot3jpahibernate.jdbc;

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
        repository.insert();
    }
}
