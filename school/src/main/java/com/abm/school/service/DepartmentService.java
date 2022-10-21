package com.abm.school.service;


import com.abm.school.dto.DepartmentDto;
import com.abm.school.entity.Department;
import com.abm.school.mapper.DepartmentMapper;
import com.abm.school.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;


    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }


    public List<DepartmentDto> getAllDepartment(){
        List<Department> departments = new ArrayList<>();
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        departmentRepository.findAll()
                .forEach(departments::add);

        for(Department department : departments){
            departmentDtos.add(departmentMapper.deptToDto(department));
        }

        return departmentDtos;
    }

    public void addDepartments(DepartmentDto department) {
        departmentRepository.save(departmentMapper.dtoToDepartment(department));}

    public DepartmentDto getDepartment(Long id){
        return departmentMapper.deptToDto(departmentRepository.findById(id).get());
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public void deleteAllDepartment(){
        departmentRepository.deleteAll();
    }




}
