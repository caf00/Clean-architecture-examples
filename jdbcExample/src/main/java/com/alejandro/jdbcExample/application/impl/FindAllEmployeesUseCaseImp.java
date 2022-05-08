package com.alejandro.jdbcExample.application.impl;

import com.alejandro.jdbcExample.application.FindAllEmployeesUseCase;
import com.alejandro.jdbcExample.domain.Employee;
import com.alejandro.jdbcExample.domain.EmployeeRepository;

import java.util.List;

public class FindAllEmployeesUseCaseImp implements FindAllEmployeesUseCase {

    private final EmployeeRepository employeeRepository;

    public FindAllEmployeesUseCaseImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> execute() {
        return employeeRepository.findAll();
    }
}
