package com.abm.school.mapper;

import com.abm.school.dto.DepartmentDto;
import com.abm.school.dto.StudentDto;
import com.abm.school.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {


    public Student dtoToStudent(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setAge(studentDto.getAge());
        DepartmentMapper departmentMapper = new DepartmentMapper();
        student.setDept(departmentMapper.dtoToDepartment(studentDto.getDept()));
        return student;
    }

    public StudentDto stuToDto(Student student){
        DepartmentDto departmentDto = DepartmentDto.DepartmentDtoBuilder.departmentDtoBuilderWith()
                .name(student.getDept().getName())
                .deptid(student.getDept().getDeptid())
                .build();


        return StudentDto.StudentDtoBuilder.studentDtoBuilderWith()
                .age(student.getAge())
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .dept(departmentDto)
                .build();

    }



}
