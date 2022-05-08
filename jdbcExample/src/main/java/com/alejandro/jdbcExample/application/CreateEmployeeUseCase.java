package com.alejandro.jdbcExample.application;

import com.alejandro.jdbcExample.domain.Employee;

public interface CreateEmployeeUseCase {
    void execute(Employee employee);
}
