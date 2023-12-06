package com.cg.technologyservice.services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cg.technologyservice.dto.TechnologyDto;
import com.cg.technologyservice.entity.Technology;
import com.cg.technologyservice.repository.TechnologyRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

	private static final Logger Logger = LoggerFactory.getLogger(TechnologyServiceImpl.class);
	private TechnologyRepository techRepo;
	
	private ModelMapper modelMapper;
	
	@Override
	public TechnologyDto saveTechnology(TechnologyDto techDto) {
		Logger.info("save Technology Executed");
		Technology tech = modelMapper.map(techDto, Technology.class);
		Technology savedTechnology = techRepo.save(tech);
		TechnologyDto techDto1 = modelMapper.map(savedTechnology, TechnologyDto.class);
		return techDto1;
	}

	@Override
	public TechnologyDto getTechnologyByCode(String techCode) {
		Technology tech =  techRepo.findByTechnologyCode(techCode);
		TechnologyDto techDto = modelMapper.map(tech, TechnologyDto.class);
		return techDto;
	}

}
