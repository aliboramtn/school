package com.abm.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;
    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department dept;

    public Student() {
    }

    public Student(Long id, String name, String surname, int age, Department dept) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dept = dept;
    }

    public Student(String name, String surname, int age, Department dept) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dept = dept;
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

    public Department getDept() {
        return dept;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }

}
