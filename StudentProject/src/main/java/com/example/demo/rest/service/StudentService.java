package com.example.demo.rest.service;


import com.example.demo.models.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.rest.assembler.StudentAssembler;
import com.example.demo.rest.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Resource
    StudentAssembler studentAssembler;

    public StudentDTO getStudent(Long id){
        Student student=studentRepository.getOne(id);
        StudentDTO studentDTO=studentAssembler.toResource(student);
        return studentDTO;

    }

    public StudentDTO saveStudent(StudentDTO studentDto) {
        Student student=new Student();
        student.setName(studentDto.getName());
        student.setGrade(studentDto.getGrade());
        student=studentRepository.saveAndFlush(student);
        return studentAssembler.toResource(student);

    }


    public List<StudentDTO> getAllStudents() {
        List <Student> students= studentRepository.findAll();
        List <StudentDTO> studentDTOS = studentAssembler.toResources(students);
        return studentDTOS;
    }


    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student student=studentRepository.findById(studentDTO.get_id()).orElse(null);
        if (student==null)
            return new StudentDTO();
        student.setName(studentDTO.getName());
        student.setGrade(studentDTO.getGrade());
        return studentDTO;

    }

    public String delete(Long id) {
        Student student=studentRepository.getOne(id);
        if (student==null)
            return "student not found";
        studentRepository.delete(student);
        return "deleted";
    }
}
