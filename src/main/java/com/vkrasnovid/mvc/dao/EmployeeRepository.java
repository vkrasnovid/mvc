package com.vkrasnovid.mvc.dao;

import com.vkrasnovid.mvc.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByName(String firstName);
    Employee findById(long id);
}
