package com.example.springrest.service;

import com.example.springrest.entity.Employee;
import com.example.springrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> showAllEmps() {
      List<Employee> employeeList=employeeRepository.findAll();
      return employeeList;
    }

    public Employee findById(int id) {

       return  employeeRepository.findById(id).orElseThrow();
    }


}
