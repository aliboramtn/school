package com.abm.school.mapper;

import com.abm.school.dto.DepartmentDto;
import com.abm.school.dto.StudentDto;
import com.abm.school.entity.Department;
import com.abm.school.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentMapper {

    private Department department;
    private DepartmentDto departmentDto;

    public Department dtoToDepartment(DepartmentDto departmentDto){
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setDeptid(departmentDto.getDeptid());
        return department;
    }

    public DepartmentDto deptToDto(Department department){
        List<StudentDto> studentDtosList = new ArrayList<StudentDto>();
        for (Student student : department.getStudents()){
            StudentDto studentDto = StudentDto.StudentDtoBuilder.studentDtoBuilderWith()
                    .id(student.getId())
                    .age(student.getAge())
                    .name(student.getName())
                    .surname(student.getSurname())
                    .build();
            studentDtosList.add(studentDto);
        }
        return DepartmentDto.DepartmentDtoBuilder.departmentDtoBuilderWith()
                .deptid(department.getDeptid())
                .name(department.getName())
                .studentDtos(studentDtosList)
                .build();

    }
}
