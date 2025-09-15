package com.example.CRUDApplication.Service;

import com.example.CRUDApplication.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee CreateEmployee(Employee emp);

    Employee UpdateEmployee(Employee employee, long id);

    void DeleteEmployee(long id);

    List<Employee> GetAllEmployee();

    Optional<Employee> GetById(long id);
}