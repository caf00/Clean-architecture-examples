package com.alejandro.jdbcExample.application;

import com.alejandro.jdbcExample.domain.Employee;

public interface FindEmployeeByIdUseCase {
    Employee execute(Long id);
}