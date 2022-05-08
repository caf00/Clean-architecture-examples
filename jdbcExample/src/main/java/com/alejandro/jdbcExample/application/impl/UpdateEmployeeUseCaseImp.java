package com.alejandro.jdbcExample.application.impl;

import com.alejandro.jdbcExample.application.UpdateEmployeeUseCase;
import com.alejandro.jdbcExample.domain.Employee;
import com.alejandro.jdbcExample.domain.EmployeeRepository;

public class UpdateEmployeeUseCaseImp implements UpdateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public UpdateEmployeeUseCaseImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void execute(Employee employee) {
        employeeRepository.update(employee);
    }
}
