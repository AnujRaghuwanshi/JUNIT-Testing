package com.example.CRUDApplication.Controller;

import com.example.CRUDApplication.Entity.Employee;
import com.example.CRUDApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody  Employee employee)
    {
        try{
            Employee emp= employeeService.CreateEmployee(employee);
            return new ResponseEntity<>(emp,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id){

        Employee emp = employeeService.UpdateEmployee(employee, id);
        return  ResponseEntity.ok(emp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.DeleteEmployee(id);
        return ResponseEntity.ok("Employee successfully deleted");
    }

    @GetMapping("get/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable long id,@RequestParam(required=false) String city){
        if(city == null || city.isBlank()){
return ResponseEntity.badRequest().body("City is required");
}       Optional<Employee> em = employeeService.GetById(id);
        if (em.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found with id " + id);
        }

        String response = employeeService.buildEmployeeWeatherMessage(em.get(),city);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll(){

        List<Employee> listemployee = employeeService.GetAllEmployee();

        return ResponseEntity.ok(listemployee);
    }
}