package com.abm.school.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long deptid;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "dept",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;

    public Department(Long deptid, String name) {
        this.deptid = deptid;
        this.name = name;
    }

    public Department(Long deptid, String name, List<Student> students) {
        this.deptid = deptid;
        this.name = name;
        this.students = students;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public Long getDeptid() {
        return deptid;
    }

    public String getName() {
        return name;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptid=" + deptid +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
