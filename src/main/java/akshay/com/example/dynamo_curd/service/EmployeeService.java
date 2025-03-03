package akshay.com.example.dynamo_curd.service;

import java.util.List;

import akshay.com.example.dynamo_curd.dto.EmployeeDTO;
import akshay.com.example.dynamo_curd.dto.ResponseDTO;

public interface EmployeeService {
    ResponseDTO<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployee(String id);

    ResponseDTO<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO);

    ResponseDTO<EmployeeDTO> deleteEmployee(String id);
}
