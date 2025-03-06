package akshay.com.example.dynamo_curd.service;

import akshay.com.example.dynamo_curd.dto.AddressDTO;
import akshay.com.example.dynamo_curd.entity.Address;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class AddressService {

    private final DynamoDBMapper dynamoDBMapper;

    public AddressService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Address addAddress(AddressDTO addressDTO) {
        if (ObjectUtils.isEmpty(addressDTO)) {
            throw new IllegalArgumentException("Employee details cannot be null");
        }

        Address address = new Address(addressDTO.getEmployeeId(), addressDTO.getCity(), addressDTO.getState());

        dynamoDBMapper.save(address);

        return address;
    }

    public List<Address> getAllAddresses(String employeeId) {
        if (!StringUtils.hasLength(employeeId)) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        String partitionKey = "EMP#" + employeeId;

        Address addressKey = new Address();
        addressKey.setPk(partitionKey);

        DynamoDBQueryExpression<Address> queryExpression = new DynamoDBQueryExpression<Address>()
                .withHashKeyValues(addressKey);

        List<Address> addressList = dynamoDBMapper.query(Address.class, queryExpression);

        return addressList;
    }

    public void deleteAddress(String employeeId, String addressId) {
        if (!StringUtils.hasLength(employeeId) || !StringUtils.hasLength(addressId)) {
            throw new IllegalArgumentException("Employee ID and Address ID cannot be null or empty");
        }

        String partitionKey = "EMP#" + employeeId;
        String sortKey = "ADDR#" + addressId;

        Address keyObject = new Address();
        keyObject.setPk(partitionKey);
        keyObject.setSk(sortKey);

        dynamoDBMapper.delete(keyObject);
    }

}