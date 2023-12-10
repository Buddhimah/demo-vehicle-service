package com.example.employee.model;

public record EmployeeRequest(
    String firstName,
    String lastName,
    String email
) {
    
}