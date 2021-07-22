package com.k.solutions.springsessionmgmt.repositories;

import com.k.solutions.springsessionmgmt.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
