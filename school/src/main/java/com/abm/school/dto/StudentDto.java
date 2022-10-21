package com.abm.school.dto;

import com.abm.school.entity.Department;

public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private DepartmentDto dept;

    public StudentDto() {
    }


    public StudentDto(StudentDtoBuilder studentDtoBuilder){
        this.id = studentDtoBuilder.id;
        this.name = studentDtoBuilder.name;
        this.surname = studentDtoBuilder.surname;
        this.age = studentDtoBuilder.age;
        this.dept = studentDtoBuilder.dept;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public DepartmentDto getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }

    public static class StudentDtoBuilder {
        private Long id;
        private String name;
        private String surname;
        private int age;
        private DepartmentDto dept;

        public StudentDtoBuilder() {
        }

        public static StudentDtoBuilder studentDtoBuilderWith(){
            return new StudentDtoBuilder();
        }

        public StudentDtoBuilder id(Long id){
            this.id = id;
            return this;
        }

        public StudentDtoBuilder name(String name){
            this.name=name;
            return this;
        }
        public StudentDtoBuilder surname(String surname){
            this.surname=surname;
            return this;
        }
        public StudentDtoBuilder age(int age){
            this.age=age;
            return this;
        }
        public StudentDtoBuilder dept(DepartmentDto dept){
            this.dept=dept;
            return this;
        }

        public StudentDto build(){
            return new StudentDto(this);
        }
    }
}
