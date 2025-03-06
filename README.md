### Spring-boot-Dynamodb-crud-application 

# single table design with two entities

command to create Dyanamo db tables:

aws dynamodb create-table \
    --table-name YourTableName \
    --attribute-definitions \
        AttributeName=PK,AttributeType=S \
        AttributeName=SK,AttributeType=S \
    --key-schema \
        AttributeName=PK,KeyType=HASH \
        AttributeName=SK,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST



# Installation steps:
     > mvn install 
     > run jar file
     > access api's http://localhost:8080/swagger-ui/index.html