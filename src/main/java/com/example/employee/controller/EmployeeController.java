package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRequest;
import com.example.employee.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employee) {
        return employeeService.createEmployee(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/employees/{employeeId}")
    public Employee updatedEmployee(@RequestBody EmployeeRequest employee, @PathVariable int employeeId) {
        return employeeService.updateEmployee(employeeId, employee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}