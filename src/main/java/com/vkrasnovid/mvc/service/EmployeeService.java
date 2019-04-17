package com.vkrasnovid.mvc.service;

import com.vkrasnovid.mvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee Employee);
    public void updateEmployee(Employee Employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(long id);
    public void removeEmployee(long id);
    public List<Employee> findEmployeeByName(String firstName);
}
