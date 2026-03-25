package com.company.service.impl;

import com.company.model.Employee;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
import com.company.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    // CRUD operations
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee existing = getEmployeeById(id);

        existing.setFirstName(emp.getFirstName());
        existing.setLastName(emp.getLastName());
        existing.setEmail(emp.getEmail());
        existing.setDepartment(emp.getDepartment());
        existing.setSalary(emp.getSalary());

        return repo.save(existing);
    }

    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        repo.delete(existing);
    }

    // Query method implementations
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return repo.findByDepartment(department);
    }

    @Override
    public List<Employee> getEmployeesBySalaryGreaterThan(BigDecimal salary) {
        return repo.findBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        return repo.findByFirstName(firstName);
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) {
        return repo.findByLastName(lastName);
    }

    @Override
    public List<Employee> getEmployeesByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentAndSalaryGreaterThan(String department, BigDecimal salary) {
        return repo.findByDepartmentAndSalaryGreaterThan(department, salary);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentOrderBySalaryDesc(String department) {
        return repo.findByDepartmentOrderBySalaryDesc(department);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentOrderByFirstNameAsc(String department) {
        return repo.findByDepartmentOrderByFirstNameAsc(department);
    }

    @Override
    public List<Employee> getEmployeesByNameContaining(String name) {
        return repo.findByNameContaining(name);
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
        return repo.findBySalaryRange(minSalary, maxSalary);
    }

    @Override
    public List<Employee> getEmployeesByDepartments(List<String> departments) {
        return repo.findByDepartments(departments);
    }

    @Override
    public List<String> getAllDepartments() {
        return repo.findAllDepartments();
    }

    @Override
    public long getEmployeeCountByDepartment(String department) {
        return repo.countByDepartment(department);
    }

    @Override
    public BigDecimal getAverageSalaryByDepartment(String department) {
        return repo.findAverageSalaryByDepartment(department);
    }

    @Override
    public BigDecimal getMaxSalaryByDepartment(String department) {
        return repo.findMaxSalaryByDepartment(department);
    }

    @Override
    public BigDecimal getMinSalaryByDepartment(String department) {
        return repo.findMinSalaryByDepartment(department);
    }
}