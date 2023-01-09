package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
