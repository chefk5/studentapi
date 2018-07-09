package com.example.demo.rest.assembler;


import com.example.demo.models.Student;
import com.example.demo.rest.controller.StudentController;
import com.example.demo.rest.dto.StudentDTO;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.beans.Customizer;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Service
public class StudentAssembler extends ResourceAssemblerSupport<Student, StudentDTO> {

    public StudentAssembler() {
        super(Student.class, StudentDTO.class);
    }

    @Override
    public StudentDTO toResource(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.set_id(student.getId());
        dto.setName(student.getName());
        dto.setGrade(student.getGrade());
        return dto;


    }

}





