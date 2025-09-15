package com.example.CRUDApplication.Service.Implementation;

import com.example.CRUDApplication.Entity.Employee;
import com.example.CRUDApplication.Repository.EmployeeRepo;
import com.example.CRUDApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSerImp implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public Employee CreateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee UpdateEmployee(Employee employee, long id) {

        Employee employeee= employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found with"));
        employeee.setName(employee.getName());
        employeee.setEmail(employee.getEmail());
        employeee.setRole(employee.getRole());
        return employeeRepository.save(employeee);
    }

    @Override
    public void DeleteEmployee(long id) {
        Employee emp=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not present with given id"));
        employeeRepository.delete(emp);
    }

    @Override
    public List<Employee> GetAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> GetById(long id) {
        return employeeRepository.findById(id);
    }
}
