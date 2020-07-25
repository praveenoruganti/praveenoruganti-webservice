package com.praveenoruganti.soapws.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.praveenoruganti.courses.CourseDetails;
import com.praveenoruganti.courses.DeleteCourseDetailsRequest;
import com.praveenoruganti.courses.DeleteCourseDetailsResponse;
import com.praveenoruganti.courses.GetAllCourseDetailsRequest;
import com.praveenoruganti.courses.GetAllCourseDetailsResponse;
import com.praveenoruganti.courses.GetCourseDetailsRequest;
import com.praveenoruganti.courses.GetCourseDetailsResponse;
import com.praveenoruganti.soapws.bean.Course;
import com.praveenoruganti.soapws.exception.CourseNotFoundException;
import com.praveenoruganti.soapws.service.CourseDetailsService;
import com.praveenoruganti.soapws.service.CourseDetailsService.Status;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;

	// method
	// input - GetCourseDetailsRequest
	// output - GetCourseDetailsResponse

	// http://praveenoruganti.com/courses
	// GetCourseDetailsRequest
	@PayloadRoot(namespace = "http://praveenoruganti.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

		Course course = service.findById(request.getId());

		if (course == null)
			throw new CourseNotFoundException("Invalid Course Id " + request.getId());

		return mapCourseDetails(course);
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Course course : courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();

		courseDetails.setId(course.getId());

		courseDetails.setName(course.getName());

		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

	@PayloadRoot(namespace = "http://praveenoruganti.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(
			@RequestPayload GetAllCourseDetailsRequest request) {

		List<Course> courses = service.findAll();

		return mapAllCourseDetails(courses);
	}

	@PayloadRoot(namespace = "http://praveenoruganti.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {

		Status status = service.deleteById(request.getId());

		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));

		return response;
	}

	private com.praveenoruganti.courses.Status mapStatus(Status status) {
		if (status == Status.FAILURE)
			return com.praveenoruganti.courses.Status.FAILURE;
		return com.praveenoruganti.courses.Status.SUCCESS;
	}
}
