package com.alejandro.jdbcExample.domain;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee findOne(long id);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(long id);
}