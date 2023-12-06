package com.cg.mentorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorDto {


	private int id;	
	private String mentorName;	
	private String mentorEmail;
	private String technologyCode;
	private String Status;
}
