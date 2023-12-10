package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRepository;
import com.example.employee.model.EmployeeRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeRequest employee) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.firstName());
        newEmployee.setLastName(employee.lastName());
        newEmployee.setEmail(employee.email());

        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(int employeeId, EmployeeRequest employee) {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(employeeId);
        updatedEmployee.setFirstName(employee.firstName());
        updatedEmployee.setLastName(employee.lastName());
        updatedEmployee.setEmail(employee.email());
        
        return employeeRepository.save(updatedEmployee);
    }
    
}