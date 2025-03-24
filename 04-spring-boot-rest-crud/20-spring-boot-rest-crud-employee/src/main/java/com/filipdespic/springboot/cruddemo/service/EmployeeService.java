package com.filipdespic.springboot.cruddemo.service;

import com.filipdespic.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
