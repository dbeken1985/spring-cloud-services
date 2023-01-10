package net.javaguides.employeeservice.service.impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.DepartmentApiClient;
import net.javaguides.employeeservice.service.EmployeeService;
import net.javaguides.employeeservice.service.OrganizationApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
    // private WebClient webClient;
    private DepartmentApiClient departmentApiClient;
    private OrganizationApiClient organizationApiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

//    @CircuitBreaker(name = "employee-service",
//            fallbackMethod = "getDefaultDepartment")
    @Override
    @Retry(name = "${spring.application.name}",
            fallbackMethod = "getDefaultDepartment")
    public ApiResponseDto getEmployeeById(Long employeeId) throws RuntimeException {

        LOGGER.info("Inside GetEmployeeByID Method '{}'",employeeId);

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", "" + employeeId));

        // Makes a rest call and return department..
//            DepartmentDto departmentDto = webClient
//                    .get()
//                    .uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
//                    .retrieve()
//                    .bodyToMono(DepartmentDto.class)
//                    .block();

        DepartmentDto departmentDto = departmentApiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationApiClient.getOrganizationByOrganizationCode(employee.getOrganizationCode());
        employee.setDepartmentCode(departmentDto.getDepartmentCode());
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto, departmentDto, organizationDto);
        return apiResponseDto;
    }

    public ApiResponseDto getDefaultDepartment(Long employeeId, Exception exception) throws RuntimeException {
        LOGGER.info("Inside GetEmployeeByID Method (default) '{}'",employeeId);

        Employee employee = employeeRepository.findById(employeeId).get();
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("10101");
        departmentDto.setDepartmentDescription("Research & Development Department");

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationName("No Org");
        organizationDto.setOrganizationCode("0000");
        organizationDto.setOrganizationDescription("No Desc");
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto, departmentDto, organizationDto);
        return apiResponseDto;
    }
}