package com.harshalmayee.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.harshalmayee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    // CREATE
    public Employee save(Employee employee){
        dynamoDBMapper.save(employee);
        return employee;
    }

    // GET_EMPLOYEE_BY_ID
    public Employee getEmployeeById(String employeeId){
        return dynamoDBMapper.load(Employee.class,employeeId);
    }

    // DELETE
    public String deleteEmployee(String employeeId){
        Employee emp=dynamoDBMapper.load(Employee.class,employeeId);
        dynamoDBMapper.delete(emp);
        return "Employee Deleted..."+employeeId;
    }

    //UPDATE
    public String updateEmployee(String employeeId,Employee employee){
        dynamoDBMapper.save(employee,
                            new DynamoDBSaveExpression()
        .withExpectedEntry("employeeId",
                           new ExpectedAttributeValue(
                                   new AttributeValue().withS(employeeId)
                           )));
        return "Employee Updated "+employeeId;
    }
}
