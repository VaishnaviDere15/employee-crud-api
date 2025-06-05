package com.example.project.repository;

import com.example.project.model.Employee;
import com.example.project.projection.EmployeeBasicInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	List<EmployeeBasicInfo> findAllBy();

	Page<EmployeeBasicInfo> findAllBy(Pageable pageable);

    Page<Employee> findAll(Pageable pageable);

    
    @Query("SELECT e FROM Employee e WHERE LOWER(e.department.name) = LOWER(:departmentName)")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword ,'%'))")
    List<Employee> searchByName(@Param("keyword") String keyword);


}