package net.javaguides.employeeservice.mapper;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

    // This will be the instance of the interface to use!!
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    // MapStruct creates code during compilation time..
    // If object have same field names.. nothing to change
    // @Mapping(source = "email", target = "emailAddress")
    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
