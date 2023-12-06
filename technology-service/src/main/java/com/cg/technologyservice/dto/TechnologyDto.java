package com.cg.technologyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TechnologyDto {

	
	private int id;
	private String technologyCode;
	private String technologyName;
	private int hoursTaken;
}
