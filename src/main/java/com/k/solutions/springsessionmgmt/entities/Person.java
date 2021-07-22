package com.k.solutions.springsessionmgmt.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Person {
    @Column
    private String name;

    @Id
    @Column(name = "mobile")
    private Integer mobileNumber;
}
