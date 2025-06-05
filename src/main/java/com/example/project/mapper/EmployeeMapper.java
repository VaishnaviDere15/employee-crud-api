package com.example.project.mapper;

import com.example.project.dtos.EmployeeDTO;
import com.example.project.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EmployeeMapper {
	EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);

}
