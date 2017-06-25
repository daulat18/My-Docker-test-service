package com.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.course.beans.Student;
@Component
public interface StudentRepository extends CrudRepository<Student, Long> {

}
