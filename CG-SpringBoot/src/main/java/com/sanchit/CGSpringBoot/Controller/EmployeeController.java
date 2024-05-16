package com.sanchit.CGSpringBoot.Controller;


import com.sanchit.CGSpringBoot.Entity.Employee;
import com.sanchit.CGSpringBoot.Service.EmployeeService;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Rest API to add employee to the database
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return employee;

    }

    //Rest API to get the employee details
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }
    
    //Rest API to delete th employees
    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable("id") Long id){
        return employeeService.deleteEmployee(id);
    }

    //Rest API to update the employees
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id,
                                   @RequestBody Employee emp){
        return employeeService.updateEmployee(id, emp);
    }


}
