package net.jazbelt.springboot3jpahibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate template;

    private static final String INSERT_QUERY= """
            insert into course (id, name, author)
            values (1, 'Learn stuff', 'John Doe');
            """;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void insert() {
        template.update(INSERT_QUERY);
    }
}
