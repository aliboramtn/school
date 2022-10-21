package com.abm.school.specification;

import com.abm.school.dto.StudentDto;
import com.abm.school.entity.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification implements Specification<Student> {

    private final StudentDto filter;

    public StudentSpecification(StudentDto filter) {
        super();
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getName() != null){
            predicates.add(criteriaBuilder.like(root.get("name"),filter.getName() + "%"));
        }
        if(filter.getSurname() != null){
            predicates.add(criteriaBuilder.equal(root.get("surname"),filter.getSurname()));
        }
        if(filter.getAge() != 0){
            predicates.add(criteriaBuilder.equal(root.get("age"),filter.getAge()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
