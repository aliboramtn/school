package com.abm.school.controller;


import com.abm.school.dto.DepartmentDto;
import com.abm.school.entity.Department;
import com.abm.school.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/dept")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/id/{id}")
    public DepartmentDto getDepartmentByID(@PathVariable("id") Long id){
        return departmentService.getDepartment(id);
    }

    @GetMapping("/all")
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/deleteall")
    public void deleteAllDepartment(){
        departmentService.deleteAllDepartment();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartment(id);
    }

    @PostMapping("/add")
    public void addDepartment(@RequestBody DepartmentDto department){
        departmentService.addDepartments(department);
    }
}
