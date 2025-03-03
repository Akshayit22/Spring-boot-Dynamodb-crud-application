package akshay.com.example.dynamo_curd.dto;

public record ResponseDTO<T>(String message, T content) {
}
