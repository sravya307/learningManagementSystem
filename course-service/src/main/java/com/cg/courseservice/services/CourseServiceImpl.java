package com.cg.courseservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cg.courseservice.dto.CourseDto;
import com.cg.courseservice.entity.Course;
import com.cg.courseservice.exceptions.CourseIdNotFoundException;
import com.cg.courseservice.repository.CourseRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

	private static final Logger Logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	private CourseRepository courseRepo;
	
	private ModelMapper modelMapper;
	
	@Override
	public CourseDto saveTechnology(CourseDto techDto) {
		Logger.info("save Technology Executed");
		Course tech = modelMapper.map(techDto, Course.class);
		Course savedTechnology = courseRepo.save(tech);
		CourseDto techDto1 = modelMapper.map(savedTechnology, CourseDto.class);
		return techDto1;
	}

	@Override
	public CourseDto getTechnologyByCode(String techCode) {
		Course tech =  courseRepo.findByTechnologyCode(techCode);
		CourseDto techDto = modelMapper.map(tech, CourseDto.class);
		return techDto;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> courses = courseRepo.findAll();
		List<CourseDto> coursesDto = courses.stream().map((course) -> modelMapper.map(course, CourseDto.class))
		.collect(Collectors.toList());
		
		return coursesDto;
	}

	@Override
	public void deleteCourseById(int id) {
		
		if(courseRepo.findById(id).isPresent()) {
			courseRepo.deleteById(id);
		}
		else {
			throw new CourseIdNotFoundException();
		}
	}

}
