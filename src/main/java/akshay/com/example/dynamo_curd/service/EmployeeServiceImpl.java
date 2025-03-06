
package akshay.com.example.dynamo_curd.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import akshay.com.example.dynamo_curd.dto.EmployeeDTO;

import akshay.com.example.dynamo_curd.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final DynamoDBMapper dynamoDBMapper;

    public EmployeeServiceImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (ObjectUtils.isEmpty(employeeDTO)) {
            throw new IllegalArgumentException("Employee details cannot be null");
        }
        String uniqueId = UUID.randomUUID().toString();

        Employee employee = new Employee(
                "EMP#" + uniqueId, // pk
                "EMP#" + uniqueId, // sk
                employeeDTO.name(),
                employeeDTO.monthlySalary(),
                employeeDTO.birthDate(),
                employeeDTO.phone(),
                employeeDTO.email(),
                employeeDTO.isMarried());
        dynamoDBMapper.save(employee);
        return employeeDTO;
    }

    public List<Employee> getAllEmployees() {
        return dynamoDBMapper.scan(Employee.class, new DynamoDBScanExpression());
    }

    public Employee getEmployeeById(String employeeId) {
        if (!StringUtils.hasLength(employeeId)) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        String partitionKey = "EMP#" + employeeId;
        String sortKey = partitionKey;

        return dynamoDBMapper.load(Employee.class, partitionKey, sortKey);
    }

    public void deleteEmployeeById(String employeeId) {
        if (!StringUtils.hasLength(employeeId)) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        String partitionKey = "EMP#" + employeeId;

        Employee keyObject = new Employee();
        keyObject.setPk(partitionKey);

        DynamoDBQueryExpression<Employee> queryExpression = new DynamoDBQueryExpression<Employee>()
                .withHashKeyValues(keyObject);

        List<Employee> itemsToDelete = dynamoDBMapper.query(Employee.class, queryExpression);

        dynamoDBMapper.batchDelete(itemsToDelete);
    }

}
