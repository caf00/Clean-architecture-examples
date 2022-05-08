package com.alejandro.jdbcExample.application;

import com.alejandro.jdbcExample.domain.Employee;

import java.util.List;

public interface FindAllEmployeesUseCase {
    List<Employee> execute();
}