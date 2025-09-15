package com.example.CRUDApplication.Service.Implementation;

import com.example.CRUDApplication.Entity.Employee;
import com.example.CRUDApplication.Repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeSerImpTest {
    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeSerImp employeeService;

    public EmployeeSerImpTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testsaveEmployee(){
        Employee emp = new Employee(8L,"Alex","alex@test.com","Manager");
        when(employeeRepo.save(emp)).thenReturn(emp);

        Employee saved = employeeService.CreateEmployee(emp);

        assertThat(saved.getName()).isEqualTo("Alex");
        verify(employeeRepo, times(1)).save(emp);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Anuj", "anuj@test.com", "Developer"),
                new Employee(2L, "Rahul", "rahul@test.com", "Tester")
        );
        when(employeeRepo.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.GetAllEmployee();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Anuj");
        assertThat(result.get(1).getEmail()).isEqualTo("rahul@test.com");
        verify(employeeRepo, times(1)).findAll();
    }


    @Test
    void testGetEmployeeById_Found() {
        Employee emp = new Employee(1L, "Anuj", "anuj@test.com", "Developer");
        when(employeeRepo.findById(1L)).thenReturn(Optional.of(emp));

        Optional<Employee> result = employeeService.GetById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("anuj@test.com");
    }

    @Test
    void testDeleteEmployee() {
        Long id = 1L;
        Employee emp = new Employee(1L, "Anuj", "anuj@test.com", "Developer");

        when(employeeRepo.findById(id)).thenReturn(Optional.of(emp));
        doNothing().when(employeeRepo).delete(emp);

        employeeService.DeleteEmployee(id);

        verify(employeeRepo, times(1)).findById(id);
        verify(employeeRepo, times(1)).delete(emp);
    }


}
