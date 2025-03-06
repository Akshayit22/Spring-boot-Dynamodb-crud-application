package akshay.com.example.dynamo_curd.service;

import java.util.List;

import akshay.com.example.dynamo_curd.dto.EmployeeDTO;
import akshay.com.example.dynamo_curd.entity.Employee;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<Employee> getAllEmployees();

    void deleteEmployeeById(String employeeId);

    Employee getEmployeeById(String employeeId);

}
