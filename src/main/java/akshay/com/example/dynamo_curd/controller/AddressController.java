package akshay.com.example.dynamo_curd.controller;

import akshay.com.example.dynamo_curd.dto.AddressDTO;
import akshay.com.example.dynamo_curd.entity.Address;
import akshay.com.example.dynamo_curd.service.AddressService;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
//     private final EmployeeService employeeService;

    @PostMapping("/add")
    public Address addAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.addAddress(addressDTO);
    }

    @GetMapping("/{employeeId}/addresses")
    public ResponseEntity<List<Address>> getAllAddresses(@PathVariable String employeeId) {
        List<Address> addresses = addressService.getAllAddresses(employeeId);
        return ResponseEntity.ok(addresses);
    }
}
