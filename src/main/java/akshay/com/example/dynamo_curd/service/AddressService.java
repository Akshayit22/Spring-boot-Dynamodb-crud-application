// package akshay.com.example.dynamo_curd.service;

// import akshay.com.example.dynamo_curd.dto.ResponseDTO;
// import akshay.com.example.dynamo_curd.entity.Address;
// import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// @Service
// @RequiredArgsConstructor
// public class AddressService {

//     private final DynamoDBMapper dynamoDBMapper;

//     public ResponseDTO<Address> saveAddress(Address address) {
//         dynamoDBMapper.save(address);
//         return new ResponseDTO<>("Address saved successfully", address);
//     }

//     public ResponseDTO<Address> updateAddress(Address address) {
//         dynamoDBMapper.save(address);
//         return new ResponseDTO<>("Address updated successfully", address);
//     }
// }