// package akshay.com.example.dynamo_curd.controller;

// import akshay.com.example.dynamo_curd.dto.ResponseDTO;
// import akshay.com.example.dynamo_curd.entity.Address;
// import akshay.com.example.dynamo_curd.entity.Employee;
// import akshay.com.example.dynamo_curd.service.AddressService;
// import akshay.com.example.dynamo_curd.service.EmployeeService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/address")
// @RequiredArgsConstructor
// public class AddressController {

//     private final AddressService addressService;
//     private final EmployeeService employeeService;

//     @PostMapping("/add")
//     public ResponseDTO<Address> addAddress(@RequestBody Address address) {
//         return addressService.saveAddress(address);
//     }

//     @PutMapping("/update")
//     public ResponseDTO<Address> updateAddress(@RequestBody Address address) {
//         return addressService.updateAddress(address);
//     }

//     // @GetMapping("/employee/details/{id}")
//     // public ResponseDTO<Employee> getEmployeeDetails(@PathVariable String id) {
//     //     return employeeService.getEmployeeWithAddress(id);
//     // }
// }
