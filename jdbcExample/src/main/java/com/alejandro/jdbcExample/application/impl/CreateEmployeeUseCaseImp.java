package com.alejandro.jdbcExample.application.impl;


import com.alejandro.jdbcExample.application.CreateEmployeeUseCase;
import com.alejandro.jdbcExample.domain.Employee;
import com.alejandro.jdbcExample.domain.EmployeeRepository;

public class CreateEmployeeUseCaseImp implements CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public CreateEmployeeUseCaseImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void execute(Employee employee) {
        employeeRepository.save(employee);
    }
}
