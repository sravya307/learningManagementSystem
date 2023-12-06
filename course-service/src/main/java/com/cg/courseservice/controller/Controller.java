package com.cg.courseservice.controller;




import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.cg.courseservice.dto.CourseDto;
import com.cg.courseservice.exceptions.CourseIdNotFoundException;
import com.cg.courseservice.exceptions.ErrorDetails;
import com.cg.courseservice.services.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

	private static final Logger Logger = LoggerFactory.getLogger(Controller.class); 
	
	private CourseService courseServ;
	
	@PostMapping("add")
	@ResponseStatus(HttpStatus.CREATED)
	public CourseDto addTechnology(@RequestBody CourseDto tech) {
		Logger.info("post request");
		return courseServ.saveTechnology(tech);	
	}
	
	@GetMapping("get/{code}")
	@ResponseStatus(HttpStatus.OK)
	public CourseDto getTechnologyByCode(@PathVariable("code") String techCode) {
		Logger.info("get request");
		return courseServ.getTechnologyByCode(techCode);
	}
	
	@GetMapping("getall")
	@ResponseStatus(HttpStatus.OK)
	public List<CourseDto> getAllTechnologyDetails() {
		return courseServ.getAllCourses();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCourseById(@PathVariable int id) {
		courseServ.deleteCourseById(id);
		return "Deleted Course by Id"+id;
	}
	
	@ExceptionHandler(CourseIdNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetails handleUserNotFoundException(CourseIdNotFoundException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"Course Not Found");
		
		return errorDetails;
	}
	
}
