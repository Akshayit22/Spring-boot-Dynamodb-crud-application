package akshay.com.example.dynamo_curd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import akshay.com.example.dynamo_curd.dto.EmployeeDTO;
import akshay.com.example.dynamo_curd.entity.Employee;
import akshay.com.example.dynamo_curd.service.AddressService;
import akshay.com.example.dynamo_curd.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable("id") String id){
        employeeService.deleteEmployeeById(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{employeeId}/addresses/{addressId}")
    public HttpStatus deleteAddress(@PathVariable String employeeId, @PathVariable String addressId) {
        addressService.deleteAddress(employeeId, addressId);
        return HttpStatus.OK;
    }

}
