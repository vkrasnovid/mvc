package com.vkrasnovid.mvc.dao;

import com.vkrasnovid.mvc.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDAOImpl implements EmployeeDAO{
    private final JdbcTemplate jdbcTemplate;
    private final EmployeeRowMapper employeeMapper = new EmployeeRowMapper();
    private final PluralMapper pluralMapper = new PluralMapper();

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        final String sql = "SELECT id, age, name FROM employees";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        return maps.stream().map(pluralMapper).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByName(String name) {
        final String sql = "SELECT id, age, name FROM employees WHERE name = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, name);

        return rows.stream().map(pluralMapper).collect(Collectors.toList());
    }

    @Override
    public Employee findById(long id) {
        final String sql = String.format("SELECT id, age, name FROM employees WHERE id = %s", id);
        return jdbcTemplate.queryForObject(sql, employeeMapper);
    }

    @Override
    public void insert(Employee employee) {
        final String sql = "INSERT INTO employees (age, name) VALUES (?,?)";
        jdbcTemplate.update(sql,
                employee.getAge(),
                employee.getName());
    }

    @Override
    public void update(Employee employee) {
        final String sql = "UPDATE employees SET age = ?, name = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                employee.getAge(),
                employee.getName(),
                employee.getId());
    }

    @Override
    public void removeEmployee(long id) {
        final String sql = "DELETE FROM employees where id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class PluralMapper implements Function<Map<String, Object>, Employee> {
        @Override
        public Employee apply(Map<String, Object> row) {
            Employee employee = new Employee();
            employee.setId(Long.valueOf(String.valueOf(row.get("id"))));
            employee.setAge(Integer.valueOf(String.valueOf(row.get("age"))));
            employee.setName(String.valueOf(row.get("name")));

            return employee;
        }
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setAge(rs.getInt("age"));
            employee.setName(rs.getString("name"));
            employee.setId(rs.getLong("id"));

            return employee;
        }
    }

}
