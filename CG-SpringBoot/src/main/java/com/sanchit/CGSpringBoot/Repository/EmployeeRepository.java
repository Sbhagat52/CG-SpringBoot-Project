package com.sanchit.CGSpringBoot.Repository;

import com.sanchit.CGSpringBoot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
