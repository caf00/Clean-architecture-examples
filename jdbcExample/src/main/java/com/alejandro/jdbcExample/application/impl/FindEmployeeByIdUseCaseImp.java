package com.alejandro.jdbcExample.application.impl;


import com.alejandro.jdbcExample.application.FindEmployeeByIdUseCase;
import com.alejandro.jdbcExample.domain.Employee;
import com.alejandro.jdbcExample.domain.EmployeeRepository;

public class FindEmployeeByIdUseCaseImp implements FindEmployeeByIdUseCase {

    private final EmployeeRepository employeeRepository;

    public FindEmployeeByIdUseCaseImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee execute(Long id) {
        return employeeRepository.findOne(id);
    }
}
