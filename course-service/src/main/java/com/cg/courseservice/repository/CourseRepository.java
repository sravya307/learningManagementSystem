package com.cg.courseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.courseservice.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	Course findByTechnologyCode(String technologyCode);
}
