package com.sanchit.CGSpringBoot.Service;
import java.util.NoSuchElementException;


import com.sanchit.CGSpringBoot.Entity.Employee;
import com.sanchit.CGSpringBoot.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }



    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee doesnot exist"));
    }


    public Employee deleteEmployee(Long id) {
        Employee employeeToDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee doesnot exist"));
        employeeRepository.deleteById(id);
        return employeeToDelete;
    }


    public Employee updateEmployee(Long id, Employee emp) {

        Employee updatedEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee doesnot exist"));

        updatedEmployee.setFirstName(emp.getFirstName());
        updatedEmployee.setLastName(emp.getLastName());
        updatedEmployee.setDateOfBirth(emp.getDateOfBirth());
        updatedEmployee.setLast4SSN(emp.getLast4SSN());

        return employeeRepository.save(updatedEmployee);


    }
}