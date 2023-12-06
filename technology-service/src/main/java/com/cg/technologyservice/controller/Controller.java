package com.cg.technologyservice.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.technologyservice.dto.TechnologyDto;
import com.cg.technologyservice.services.TechnologyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("technology")
public class Controller {

	private static final Logger Logger = LoggerFactory.getLogger(Controller.class); 
	
	private TechnologyService techServ;
	
	@PostMapping("add")
	@ResponseStatus(HttpStatus.CREATED)
	public TechnologyDto addTechnology(@RequestBody TechnologyDto tech) {
		Logger.info("post request");
		return techServ.saveTechnology(tech);	
	}
	
	@GetMapping("get/{code}")
	@ResponseStatus(HttpStatus.OK)
	public TechnologyDto getTechnologyByCode(@PathVariable("code") String techCode) {
		Logger.info("get request");
		return techServ.getTechnologyByCode(techCode);
	}
}
