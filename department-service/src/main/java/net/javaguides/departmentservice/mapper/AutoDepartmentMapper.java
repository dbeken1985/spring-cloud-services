package net.javaguides.departmentservice.mapper;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    // This will be the instance of the interface to use!!
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    // MapStruct creates code during compilation time..
        // If object have same field names.. nothing to change
    // @Mapping(source = "email", target = "emailAddress")
    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
