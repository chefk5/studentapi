package com.example.demo.models;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long grade;

}
