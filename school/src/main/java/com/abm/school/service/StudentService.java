package com.abm.school.service;

import com.abm.school.dto.StudentDto;
import com.abm.school.entity.Student;
import com.abm.school.mapper.DepartmentMapper;
import com.abm.school.mapper.StudentMapper;
import com.abm.school.repository.StudentRepository;
import com.abm.school.specification.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper,DepartmentMapper departmentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.departmentMapper = departmentMapper;
    }

    public List<StudentDto> getAllStudents() {

        List<Student> students = new ArrayList<>();
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findAll()
                .forEach(students::add);

        for (Student student : students){
            studentDtos.add(studentMapper.stuToDto(student));
        }

        return studentDtos;
    }


    public List<StudentDto> getAllStudentsSortedAndPaginated(Pageable pageable,StudentDto filter) {
        Specification<Student> spec = new StudentSpecification(filter);
        List<Student> students = new ArrayList<>();
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findAll(spec,pageable)
                .forEach(students::add);

        for (Student student : students){
            studentDtos.add(studentMapper.stuToDto(student));
        }

        return studentDtos;
    }




    public void addStudent(StudentDto studentDto) {
        studentRepository.save(studentMapper.dtoToStudent(studentDto));
    }

    public StudentDto getStudent(Long id) {
        return studentMapper.stuToDto(studentRepository.findById(id).get());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudent(){
        studentRepository.deleteAll();
    }

    public void updateStudent(Long id, StudentDto student){
        Student oldstudent = studentRepository.findById(id).get();
        if(student.getName() != null){
            oldstudent.setName(student.getName());
        }
        if(student.getSurname() != null){
            oldstudent.setSurname(student.getSurname());
        }
        if(student.getAge() != 0){
            oldstudent.setAge(student.getAge());
        }
        if(student.getDept() != null){
            oldstudent.setDept(departmentMapper.dtoToDepartment(student.getDept()));
        }
        studentRepository.save(oldstudent);

    }



}
