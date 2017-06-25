package com.course.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.course.beans.Course;
import com.course.beans.Student;
import com.course.repository.CourseRepository;
import com.course.repository.StudentRepository;
import com.course.utility.Utility;


@RestController
@RequestMapping("/course-application")
public class RetriveInformation {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	
	static final Logger logger = LogManager.getLogger(RetriveInformation.class.getName());
	@RequestMapping(value = "/universities", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<String> getAllUniversities() {
        
		try{
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(Utility.uri, String.class);
		 return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e){
			logger.info("Exception"+e.getMessage());
			return new ResponseEntity<>("Server Down", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value="/courses",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAllCourses() {
		
		try{
			List<Course> course=(List<Course>) courseRepository.findAll();
			
			return new ResponseEntity<>(course, HttpStatus.OK);
			}catch(Exception e){
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}
	}

	@RequestMapping(value="/enrolled-students",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllEnrolledStudents() {
		
		try{
		List<Student> students=(List<Student>) studentRepository.findAll();
		
		return new ResponseEntity<>(students, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	
}
