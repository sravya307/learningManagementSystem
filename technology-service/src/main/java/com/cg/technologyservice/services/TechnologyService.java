package com.cg.technologyservice.services;

import com.cg.technologyservice.dto.TechnologyDto;

public interface TechnologyService {

	TechnologyDto saveTechnology(TechnologyDto techDto);
	
	TechnologyDto getTechnologyByCode(String techCode);
	
	
}
