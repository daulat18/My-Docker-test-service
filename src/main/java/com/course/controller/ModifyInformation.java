package com.course.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.course.beans.Course;
import com.course.beans.Student;
import com.course.repository.CourseRepository;
import com.course.repository.StudentRepository;
import com.course.utility.Utility;

@Controller
@RequestMapping("/course-application")
public class ModifyInformation {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	static final Logger logger = LogManager.getLogger(ModifyInformation.class.getName());

	@RequestMapping(value = "/course/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Course> addCourses(@RequestBody Course course) {
		Course _course=courseRepository.save(course);
		return new ResponseEntity<>(_course, HttpStatus.CREATED);
	}

	@RequestMapping(value="/students/add",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Student> addStudents(@RequestBody Student student) {
		Student _student=studentRepository.save(student);
		return new ResponseEntity<>(_student, HttpStatus.CREATED);
	}

	@RequestMapping(value="/course/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
		try
		{
			Course course=courseRepository.findOne(id);
			if(null!=course){
		courseRepository.delete(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}

	@RequestMapping(value="/students/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
		try
		{
			Student student=studentRepository.findOne(id);
			if(null!=student){
				studentRepository.delete(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
