package com.example.springrest.controller;

import com.example.springrest.Exception.NoSuchEmployeeException;
import com.example.springrest.entity.Employee;
import com.example.springrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employeeList = employeeService.showAllEmps();
        return employeeList;

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID= " + id + "in DB");
        }
        return employee;
    }

    @PostMapping("/employees")
    public String addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Employee was added!";
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;

    }
    @DeleteMapping("/employees/{id}")
    public String  deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with id= " + id);
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " +id + "was deleted!";
    }


}
