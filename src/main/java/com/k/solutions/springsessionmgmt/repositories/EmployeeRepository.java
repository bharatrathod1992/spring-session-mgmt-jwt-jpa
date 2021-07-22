package com.k.solutions.springsessionmgmt.repositories;

import com.k.solutions.springsessionmgmt.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
