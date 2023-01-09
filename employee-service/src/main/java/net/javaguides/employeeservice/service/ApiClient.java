package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Class will be dynamically generated
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
// With Dynamic Load Balancing -> Eureka will take over
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    // Build and get department rest api -> how EmployeeService contacts department service
    @GetMapping("api/department/{department-code}")
    DepartmentDto getDepartmentByDepartmentCode(@PathVariable("department-code") String departmentCode);

}
