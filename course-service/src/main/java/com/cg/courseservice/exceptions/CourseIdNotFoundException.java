package com.cg.courseservice.exceptions;

public class CourseIdNotFoundException extends RuntimeException{

	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	
	
	public CourseIdNotFoundException() {
		super();
	}


	public CourseIdNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s: %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
