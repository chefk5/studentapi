package com.example.demo.rest.controller;


import com.example.demo.models.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.rest.assembler.StudentAssembler;
import com.example.demo.rest.dto.StudentDTO;
import com.example.demo.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class StudentController {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;



    @GetMapping("/hi")
    public String hi(){
        return "hello world";
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable(value = "id") Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDto){
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable(value = "id")Long id, @RequestBody StudentDTO studentDTO){
        studentDTO.set_id(id);
        return studentService.updateStudent(studentDTO);

    }
    //should be changes to DeleteMapping
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id){
        return studentService.delete(id);
    }



}
