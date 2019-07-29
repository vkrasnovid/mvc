package com.vkrasnovid.mvc.service;

import com.vkrasnovid.mvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee Employee);
    void updateEmployee(Employee Employee);
    Iterable<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    void removeEmployee(long id);
    List<Employee> findEmployeeByName(String firstName);
}
