package com.alejandro.jdbcExample.infraestructure.repository;

import com.alejandro.jdbcExample.domain.Employee;
import com.alejandro.jdbcExample.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryH2Impl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryH2Impl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Employee employee) {
        String insertEmployee = "insert into employees(first_name, last_name) "
                + "values (?, ?, ?)";
        jdbcTemplate.update(
                insertEmployee,
                employee.getFirstName(),
                employee.getLastName()
        );
    }

    @Override
    public Employee findOne(long id) {
        String selectOneEmployee = "select id, first_name, last_name "
                + "from employees where id = ?";
        return jdbcTemplate.queryForObject(selectOneEmployee, this::mapRowToEmployee, id);
    }

    @Override
    public List<Employee> findAll() {
        String selectAllEmployees = "select id, first_name, last_name from employees";
        return jdbcTemplate.query(selectAllEmployees, this::mapRowToEmployee);
    }

    @Override
    public void update(Employee employee) {
        String updateEmployee = "update employees set first_name = ?, last_name = ? " +
                "where id = ?";
        jdbcTemplate.update(updateEmployee
                , employee.getFirstName()
                , employee.getLastName()
                , employee.getId());
    }

    @Override
    public void delete(long id) {
        String deleteEmployee = "delete from employees where id = ?";
        jdbcTemplate.update(deleteEmployee, id);
    }

    private Employee mapRowToEmployee(ResultSet resultSet, int rowNum) throws SQLException {
        return new Employee(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name")
        );
    }
}

