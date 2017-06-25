package com.course.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.course.beans.Student;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CourseApplicationStepDef {
	@Autowired
    private TestRestTemplate restTemplate;
 
    private ResponseEntity<Student> studentResponse;
	
	
	String url="http://localhost:8090/course-application/universities";
	@When("^the client calls /universities$")
	public void the_client_calls_universities() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		executeGet(url);
	}

	private void executeGet(String url2) {
		// TODO Auto-generated method stub
		 this.studentResponse = this.restTemplate.getForEntity(url, Student.class,HttpMethod.GET);
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int status) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("studentResponse.getStatusCode()" + studentResponse.getStatusCode());
		Assert.assertEquals(status, studentResponse.getStatusCode().value()==200);
	}

	@Then("^the client receives list of universities$")
	public void the_client_receives_list_of_universities(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives EXPECTATION_FAILED message$")
	public void the_client_receives_EXPECTATION_FAILED_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives Method Not Allowed message$")
	public void the_client_receives_Method_Not_Allowed_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the client calls /courses$")
	public void the_client_calls_courses() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives list of courses$")
	public void the_client_receives_list_of_courses(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the client calls /enrolled-students$")
	public void the_client_calls_enrolled_students() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives list of enrolled students$")
	public void the_client_receives_list_of_enrolled_students(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the client calls /course/add json data$")
	public void the_client_calls_course_add_json_data(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives course json object$")
	public void the_client_receives_course_json_object(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the client calls /course/add$")
	public void the_client_calls_course_add() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the client calls /course/delete/(\\d+)$")
	public void the_client_calls_course_delete(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives Deleted course id (\\d+)$")
	public void the_client_receives_Deleted_course_id(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives NO CONTENT$")
	public void the_client_receives_NO_CONTENT() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the client calls /students/delete/(\\d+)$")
	public void the_client_calls_students_delete(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the client receives Deleted student id (\\d+)$")
	public void the_client_receives_Deleted_student_id(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
