package com.vkrasnovid.mvc.service;

import com.vkrasnovid.mvc.dao.EmployeeRepository;
import com.vkrasnovid.mvc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void removeEmployee(long id) {
        Employee employee = this.employeeRepository.findById(id);
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findEmployeeByName(String firstName) {
        return employeeRepository.findByName(firstName);
    }
}
