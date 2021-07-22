package com.k.solutions.springsessionmgmt.services;

import com.k.solutions.springsessionmgmt.entities.Employee;
import com.k.solutions.springsessionmgmt.entities.Person;
import com.k.solutions.springsessionmgmt.repositories.EmployeeRepository;
import com.k.solutions.springsessionmgmt.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;
import java.sql.SQLException;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(rollbackFor = {SQLException.class, SQLDataException.class})
    public Person addPerson(Person person) throws SQLException{
        Employee employee = new Employee();
        employee.setId(person.getMobileNumber());
        employee.setName(person.getName());
        this.employeeRepository.save(employee);
        Person result = this.personRepository.save(person);
        if(result.getMobileNumber().equals(11)) {
            throw new SQLException("SQL EXCEPTION");
        }
        if(result.getMobileNumber().equals(22)) {
            throw new SQLDataException("SQL DATA EXCEPTION");
        }
        return result;
    }
}
