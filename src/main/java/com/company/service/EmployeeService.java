package com.company.service;

import com.company.model.Employee;
import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    // CRUD operations
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

    // Query methods
    List<Employee> getEmployeesByDepartment(String department);
    List<Employee> getEmployeesBySalaryGreaterThan(BigDecimal salary);
    List<Employee> getEmployeesByFirstName(String firstName);
    List<Employee> getEmployeesByLastName(String lastName);
    List<Employee> getEmployeesByEmail(String email);

    // Advanced queries
    List<Employee> getEmployeesByDepartmentAndSalaryGreaterThan(String department, BigDecimal salary);
    List<Employee> getEmployeesByDepartmentOrderBySalaryDesc(String department);
    List<Employee> getEmployeesByDepartmentOrderByFirstNameAsc(String department);
    List<Employee> getEmployeesByNameContaining(String name);
    List<Employee> getEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary);
    List<Employee> getEmployeesByDepartments(List<String> departments);

    // Department queries
    List<String> getAllDepartments();

    // Statistics
    long getEmployeeCountByDepartment(String department);
    BigDecimal getAverageSalaryByDepartment(String department);
    BigDecimal getMaxSalaryByDepartment(String department);
    BigDecimal getMinSalaryByDepartment(String department);
}