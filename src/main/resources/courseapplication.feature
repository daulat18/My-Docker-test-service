Feature: Course Application API 

@tag1 
Scenario: client makes call to GET /universities 
	When the client calls /universities 
	Then the client receives status code of 200 
	And the client receives list of universities 
		""""
    {"alpha_two_code": "US", "name": "California Baptist University", "country": "United States", "web_page": "http://www.calbaptist.edu/", "domain": "calbaptist.edu"}
    """
		
@tag2 
Scenario:
client makes call to GET /universities -> internal server error with EXPECTATION_FAILED 
	When the client calls /universities 
	Then the client receives status code of 500 
	And the client receives EXPECTATION_FAILED message 
	
@tag3 
Scenario: client makes call to GET /universities -> Method Not Allowed 
	When the client calls /universities 
	Then the client receives status code of 405 
	And the client receives Method Not Allowed message 
	
@tag4 
Scenario: client makes call to GET /courses 
	When the client calls /courses 
	Then the client receives status code of 200 
	And the client receives list of courses 
		"""
    {
    "course_id": 1,
    "course_name": "Computer Science"
  }
    """
		
@tag5 
Scenario: client makes call to GET /courses ->  EXPECTATION_FAILED 
	When the client calls /courses 
	Then the client receives status code of 417 
	And the client receives EXPECTATION_FAILED message 
	
@tag6 
Scenario: client makes call to GET /courses -> Method Not Allowed 
	When the client calls /courses 
	Then the client receives status code of 405 
	And the client receives Method Not Allowed message 
	
@tag7 
Scenario: client makes call to GET /enrolled-students 
	When the client calls /enrolled-students 
	Then the client receives status code of 200 
	And the client receives list of enrolled students 
		"""
   {
    "student_id": 1,
    "first_name": "daulat",
    "last_name": "bachhav",
    "university_name": "pune"
  }
    """
@tag8 
Scenario: client makes call to GET /enrolled-students ->  EXPECTATION_FAILED 
	When the client calls /enrolled-students 
	Then the client receives status code of 417 
	And the client receives EXPECTATION_FAILED message 
	
@tag9 
Scenario: client makes call to GET /enrolled-students -> Method Not Allowed 
	When the client calls /enrolled-students 
	Then the client receives status code of 405 
	And the client receives Method Not Allowed message 
	
@tag10 
Scenario: client makes call to POST /course/add -> to add new courses 
	When the client calls /course/add json data 
		"""
    {
    "course_id": 1,
    "course_name": "Computer Science"
  }
    """
	Then the client receives status code of 201 
	And the client receives course json object 
		"""
    {
    "course_id": 1,
    "course_name": "Computer Science"
  }
  """
@tag11 
Scenario: client makes call to POST /course/add ->  EXPECTATION_FAILED 
	When the client calls /course/add 
	Then the client receives status code of 417 
	And the client receives EXPECTATION_FAILED message 
	
@tag12 
Scenario: client makes call to DELETE ->Deletethe the course 
	When the client calls /course/delete/1 
	Then the client receives status code of 200 
	And the client receives Deleted course id 1 
	
@tag12 
Scenario: client makes call to DELETE ->Deletet the course 
	When the client calls /course/delete/1 
	Then the client receives status code of 204 
	And the client receives NO CONTENT 
	
@tag13 
Scenario: client makes call to DELETE ->Deletet Student 
	When the client calls /students/delete/1 
	Then the client receives status code of 200 
	And the client receives Deleted student id 1 
	
	
@tag14 
Scenario: client makes call to DELETE ->Deletet Student 
	When the client calls /students/delete/1 
	Then the client receives status code of 204 
	And the client receives NO CONTENT