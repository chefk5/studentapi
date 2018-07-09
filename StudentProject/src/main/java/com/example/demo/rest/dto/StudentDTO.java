package com.example.demo.rest.dto;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class StudentDTO extends ResourceSupport {

    Long _id;
    String name;
    Long grade;
}
