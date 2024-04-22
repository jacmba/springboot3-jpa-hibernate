package net.jazbelt.springboot3jpahibernate.jdbc;

import net.jazbelt.springboot3jpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate template;

    private static final String INSERT_QUERY = """
            insert into course (id, name, author)
            values (?, ?, ?);
            """;

    private static final String DELETE_QUERY = """
            delete from course
            where id = ?
            """;

    private static final String SELECT_QUERY = """
            select * from course
            where id = ?
            """;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void insert(Course c) {
        template.update(INSERT_QUERY, c.getId(), c.getName(), c.getAuthor());
    }

    public void deleteById(long id) {
        template.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return template.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
