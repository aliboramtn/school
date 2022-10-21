package com.abm.school.dto;

import java.util.List;

public class DepartmentDto {
    private Long deptid;
    private String name;
    private List<StudentDto> studentDtos;

    public DepartmentDto() {
    }

    public DepartmentDto(DepartmentDtoBuilder departmentDtoBuilder){
        this.deptid=departmentDtoBuilder.deptid;
        this.name= departmentDtoBuilder.name;
        this.studentDtos=departmentDtoBuilder.studentDtos;
    }

    public Long getDeptid() {
        return deptid;
    }

    public String getName() {
        return name;
    }

    public List<StudentDto> getStudentDtos() {
        return studentDtos;
    }

    public static class DepartmentDtoBuilder{
        private Long deptid;
        private String name;
        private List<StudentDto> studentDtos;

        public DepartmentDtoBuilder() {
        }

        public static DepartmentDtoBuilder departmentDtoBuilderWith(){
            return new DepartmentDtoBuilder();
        }

        public DepartmentDtoBuilder deptid(Long deptid){
            this.deptid=deptid;
            return this;
        }

        public DepartmentDtoBuilder name(String name){
            this.name=name;
            return this;
        }

        public DepartmentDtoBuilder studentDtos(List<StudentDto> studentDtos){
            this.studentDtos=studentDtos;
            return this;
        }

        public DepartmentDto build(){
            return new DepartmentDto(this);
        }
    }
}
