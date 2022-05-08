package com.alejandro.jdbcExample.infraestructure.web;

import com.alejandro.jdbcExample.application.*;
import com.alejandro.jdbcExample.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final FindAllEmployeesUseCase findAllEmployeesUseCase;
    private final FindEmployeeByIdUseCase findOneEmployeeUseCase;
    private final CreateEmployeeUseCase createNewEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;

    @Autowired
    public EmployeeController(
            FindAllEmployeesUseCase findAllEmployeesUseCase,
            FindEmployeeByIdUseCase findOneEmployeeUseCase,
            CreateEmployeeUseCase createNewEmployeeUseCase,
            DeleteEmployeeUseCase deleteEmployeeUseCase,
            UpdateEmployeeUseCase updateEmployeeUseCase) {
        this.findAllEmployeesUseCase = findAllEmployeesUseCase;
        this.findOneEmployeeUseCase = findOneEmployeeUseCase;
        this.createNewEmployeeUseCase = createNewEmployeeUseCase;
        this.deleteEmployeeUseCase = deleteEmployeeUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(findAllEmployeesUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(findOneEmployeeUseCase.execute(id));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Employee employee) {
        createNewEmployeeUseCase.execute(employee);
        return ResponseEntity.ok("Empleado guardado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Employee employee) {
        updateEmployeeUseCase.execute(employee);
        return ResponseEntity.ok("Empleado actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        deleteEmployeeUseCase.execute(id);
        return ResponseEntity.ok("Empleado eliminado correctamente");
    }
}

