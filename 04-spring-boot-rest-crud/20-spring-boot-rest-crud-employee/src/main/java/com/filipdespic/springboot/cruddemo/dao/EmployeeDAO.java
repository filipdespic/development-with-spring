package com.filipdespic.springboot.cruddemo;

import com.filipdespic.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
