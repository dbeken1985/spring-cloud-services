package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Class will be dynamically generated
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
// With Dynamic Load Balancing -> Eureka will take over
@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationApiClient {

    // Build and get organization rest api -> how EmployeeService contacts department service
    @GetMapping("api/organization/{organization-code}")
    OrganizationDto getOrganizationByOrganizationCode(@PathVariable("organization-code") String organizationCode);

}
