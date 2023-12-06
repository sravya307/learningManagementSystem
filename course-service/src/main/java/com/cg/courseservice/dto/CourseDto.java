package com.cg.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseDto {

	
	private int id;
	private String technologyCode;
	private String technologyName;
	private int hoursTaken;
}
