package akshay.com.example.dynamo_curd.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDTO {
    private String employeeId;
    private String city;
    private String state;
}
