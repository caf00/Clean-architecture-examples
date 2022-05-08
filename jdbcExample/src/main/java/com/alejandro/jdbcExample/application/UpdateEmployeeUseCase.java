package com.alejandro.jdbcExample.application;

import com.alejandro.jdbcExample.domain.Employee;

public interface UpdateEmployeeUseCase {
    void execute(Employee employee);
}