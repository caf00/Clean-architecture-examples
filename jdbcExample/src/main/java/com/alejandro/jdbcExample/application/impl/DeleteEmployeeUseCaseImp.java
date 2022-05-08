package com.alejandro.jdbcExample.application.impl;

import com.alejandro.jdbcExample.application.DeleteEmployeeUseCase;
import com.alejandro.jdbcExample.domain.EmployeeRepository;

public class DeleteEmployeeUseCaseImp implements DeleteEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public DeleteEmployeeUseCaseImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void execute(Long id) {
        employeeRepository.delete(id);
    }
}
