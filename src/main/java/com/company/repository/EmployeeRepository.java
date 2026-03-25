package com.company.repository;

import com.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;



import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  
    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(Double salary);
      @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findBySalaryGreaterThan(@Param("salary") BigDecimal salary);
}