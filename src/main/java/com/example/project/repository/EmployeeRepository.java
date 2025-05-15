package com.example.project.repository;

import com.example.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long>

{
	
	
	@Query("SELECT e from Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword ,'%'))")
	List<Employee> searchByName(@Param("keyword") String keyword);
	
	@Query("SELECT e from Employee e WHERE e.department= :department")
	List<Employee> searchByDepartment(@Param("department") String department);
	
	@Query("SELECT e FROM Employee e WHERE e.department = :department")
	List<Employee> findByDepartment(@Param("department") String department);

	
}



