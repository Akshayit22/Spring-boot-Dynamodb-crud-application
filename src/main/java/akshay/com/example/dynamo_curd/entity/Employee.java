package akshay.com.example.dynamo_curd.entity;

import java.math.BigDecimal;
import java.util.Date;

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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DynamoDBTable(tableName = "tb_employee")
public class Employee {

    @DynamoDBHashKey(attributeName = "PK")
    private String pk;

    @DynamoDBRangeKey(attributeName = "SK")
    private String sk;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private BigDecimal monthlySalary;

    @DynamoDBAttribute
    private Date birthDate;

    @DynamoDBAttribute
    private String phone;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private Boolean isMarried;
}
