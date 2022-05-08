package com.alejandro.jdbcExample;


import com.alejandro.jdbcExample.application.*;
import com.alejandro.jdbcExample.application.impl.*;
import com.alejandro.jdbcExample.domain.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateEmployeeUseCase createNewEmployeeUseCase(EmployeeRepository employeeRepository) {
        return new CreateEmployeeUseCaseImp(employeeRepository);
    }

    @Bean
    public FindAllEmployeesUseCase findAllEmployeesUseCase(EmployeeRepository employeeRepository) {
        return new FindAllEmployeesUseCaseImp(employeeRepository);
    }

    @Bean
    public FindEmployeeByIdUseCase findOneEmployeeUseCase(EmployeeRepository employeeRepository) {
        return new FindEmployeeByIdUseCaseImp(employeeRepository);
    }

    @Bean
    public UpdateEmployeeUseCase updateEmployeeUseCase(EmployeeRepository employeeRepository) {
        return new UpdateEmployeeUseCaseImp(employeeRepository);
    }

    @Bean
    public DeleteEmployeeUseCase deleteEmployeeUseCase(EmployeeRepository employeeRepository) {
        return new DeleteEmployeeUseCaseImp(employeeRepository);
    }
}
