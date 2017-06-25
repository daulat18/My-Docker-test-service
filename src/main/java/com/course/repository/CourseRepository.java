package com.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.course.beans.Course;
@Component
public interface CourseRepository extends CrudRepository<Course,Long>{

}
