package com.harshalmayee.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamoDBDocument
public class Department {

    @DynamoDBAttribute
    private String departmentCode;
    @DynamoDBAttribute
    private String departmentName;
}
