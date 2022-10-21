package com.abm.school.controller;
import antlr.collections.impl.LList;
import com.abm.school.dto.StudentDto;
import com.abm.school.entity.Student;
import com.abm.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/student")
@RestController
public class Controller {

    private final StudentService studentService;

    @Autowired
    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/id/{id}")
    public StudentDto getStudentByID(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/all")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/allpaged")
    public List<StudentDto> getAllStudentSorted(Pageable pageable,@RequestBody StudentDto studentDto){
        return studentService.getAllStudentsSortedAndPaginated(pageable,studentDto);
    }

    @DeleteMapping("/deleteall")
    public void deleteAllStudent(){
        studentService.deleteAllStudent();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentDto student){
        studentService.addStudent(student);
    }


    @PutMapping("/update/{id}")
    public void updateStudent(@RequestBody StudentDto student,@PathVariable("id") Long id){
        studentService.updateStudent(id, student);
    }




}
