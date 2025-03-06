package akshay.com.example.dynamo_curd.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_employee")
public class Address {

    @DynamoDBHashKey(attributeName = "PK")
    private String pk;

    @DynamoDBRangeKey(attributeName = "SK")
    private String sk;

    @DynamoDBAttribute
    private String addressId;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String state;

    // Constructor to initialize Address with employeeId, city, and state
    public Address(String employeeId, String city, String state) {
        this.addressId = java.util.UUID.randomUUID().toString();
        this.pk = "EMP#" + employeeId;
        this.sk = "ADDR#" + this.addressId;
        this.city = city;
        this.state = state;
    }
}