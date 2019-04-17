package com.vkrasnovid.mvc.dao;

import com.vkrasnovid.mvc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    List<Employee> findByName(String firstName);
    Employee findById(long id);
    void insert(Employee employee);
    void update(Employee employee);
    void removeEmployee(long id);
}
