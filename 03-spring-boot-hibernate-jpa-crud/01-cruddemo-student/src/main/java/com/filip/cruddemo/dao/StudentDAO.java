package com.filip.cruddemo.dao;

import com.filip.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    void findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
}
