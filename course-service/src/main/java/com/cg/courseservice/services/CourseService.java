package com.cg.courseservice.services;

import java.util.List;

import com.cg.courseservice.dto.CourseDto;
import com.cg.courseservice.entity.Course;

public interface CourseService {

	CourseDto saveTechnology(CourseDto techDto);
	
	CourseDto getTechnologyByCode(String techCode);
	
	List<CourseDto> getAllCourses();
	
	void deleteCourseById(int id);
	
	
}
