package com.filipdespic.springboot.cruddemo.dao;

import com.filipdespic.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
