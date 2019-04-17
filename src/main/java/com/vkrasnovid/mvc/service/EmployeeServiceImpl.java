package com.vkrasnovid.mvc.service;

import com.vkrasnovid.mvc.dao.EmployeeDAO;
import com.vkrasnovid.mvc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.insert(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void removeEmployee(long id) {
        employeeDAO.removeEmployee(id);
    }

    @Override
    public List<Employee> findEmployeeByName(String firstName) {
        return employeeDAO.findByName(firstName);
    }
}
