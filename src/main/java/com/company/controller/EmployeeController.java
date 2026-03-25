package com.company.controller;

import com.company.model.Employee;
import com.company.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CRUD operations
    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee emp) {
        return new ResponseEntity<>(service.createEmployee(emp), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Query endpoints
    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    }

    @GetMapping("/salary/greater/{salary}")
    public List<Employee> getBySalaryGreaterThan(@PathVariable BigDecimal salary) {
        return service.getEmployeesBySalaryGreaterThan(salary);
    }

    @GetMapping("/firstname/{firstName}")
    public List<Employee> getByFirstName(@PathVariable String firstName) {
        return service.getEmployeesByFirstName(firstName);
    }

    @GetMapping("/lastname/{lastName}")
    public List<Employee> getByLastName(@PathVariable String lastName) {
        return service.getEmployeesByLastName(lastName);
    }

    @GetMapping("/email/{email}")
    public List<Employee> getByEmail(@PathVariable String email) {
        return service.getEmployeesByEmail(email);
    }

    @GetMapping("/department/{department}/salary/greater/{salary}")
    public List<Employee> getByDepartmentAndSalaryGreaterThan(@PathVariable String department, @PathVariable BigDecimal salary) {
        return service.getEmployeesByDepartmentAndSalaryGreaterThan(department, salary);
    }

    @GetMapping("/department/{department}/order-by-salary-desc")
    public List<Employee> getByDepartmentOrderBySalaryDesc(@PathVariable String department) {
        return service.getEmployeesByDepartmentOrderBySalaryDesc(department);
    }

    @GetMapping("/department/{department}/order-by-name-asc")
    public List<Employee> getByDepartmentOrderByFirstNameAsc(@PathVariable String department) {
        return service.getEmployeesByDepartmentOrderByFirstNameAsc(department);
    }

    @GetMapping("/search/name/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return service.getEmployeesByNameContaining(name);
    }

    @GetMapping("/salary-range")
    public List<Employee> getBySalaryRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return service.getEmployeesBySalaryRange(min, max);
    }

    @GetMapping("/departments")
    public List<String> getAllDepartments() {
        return service.getAllDepartments();
    }

    @PostMapping("/by-departments")
    public List<Employee> getByDepartments(@RequestBody List<String> departments) {
        return service.getEmployeesByDepartments(departments);
    }

    // Statistics endpoints
    @GetMapping("/department/{department}/count")
    public long getCountByDepartment(@PathVariable String department) {
        return service.getEmployeeCountByDepartment(department);
    }

    @GetMapping("/department/{department}/avg-salary")
    public BigDecimal getAverageSalaryByDepartment(@PathVariable String department) {
        return service.getAverageSalaryByDepartment(department);
    }

    @GetMapping("/department/{department}/max-salary")
    public BigDecimal getMaxSalaryByDepartment(@PathVariable String department) {
        return service.getMaxSalaryByDepartment(department);
    }

    @GetMapping("/department/{department}/min-salary")
    public BigDecimal getMinSalaryByDepartment(@PathVariable String department) {
        return service.getMinSalaryByDepartment(department);
    }
}