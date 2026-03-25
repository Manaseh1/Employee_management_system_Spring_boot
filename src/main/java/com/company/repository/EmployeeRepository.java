package com.company.repository;

import com.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Basic queries
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByEmail(String email);

    // Combined queries
    List<Employee> findByDepartmentAndSalaryGreaterThan(String department, BigDecimal salary);
    List<Employee> findByDepartmentOrderBySalaryDesc(String department);
    List<Employee> findByDepartmentOrderByFirstNameAsc(String department);

    // Custom queries with @Query
    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Employee> findByNameContaining(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findBySalaryRange(@Param("minSalary") BigDecimal minSalary, @Param("maxSalary") BigDecimal maxSalary);

    @Query("SELECT DISTINCT e.department FROM Employee e ORDER BY e.department")
    List<String> findAllDepartments();

    @Query("SELECT e FROM Employee e WHERE e.department IN :departments")
    List<Employee> findByDepartments(@Param("departments") List<String> departments);

    // Aggregation queries
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.department = :department")
    long countByDepartment(@Param("department") String department);

    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department = :department")
    BigDecimal findAverageSalaryByDepartment(@Param("department") String department);

    @Query("SELECT MAX(e.salary) FROM Employee e WHERE e.department = :department")
    BigDecimal findMaxSalaryByDepartment(@Param("department") String department);

    @Query("SELECT MIN(e.salary) FROM Employee e WHERE e.department = :department")
    BigDecimal findMinSalaryByDepartment(@Param("department") String department);
}