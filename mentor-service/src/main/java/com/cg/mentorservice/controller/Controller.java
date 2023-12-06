package com.cg.mentorservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mentorservice.dto.APIResponseDto;
import com.cg.mentorservice.dto.MentorDto;
import com.cg.mentorservice.services.MentorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("mentor")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

	private static final Logger Logger = LoggerFactory.getLogger(Controller.class);
	
	private MentorService mentorService;
	
	@PostMapping("add")
	@ResponseStatus(HttpStatus.CREATED)
	public MentorDto addMentor(@RequestBody MentorDto mentorDto) {
		Logger.info("post request");
		return mentorService.addMentor(mentorDto);
	}
	
	@GetMapping("get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public APIResponseDto getMentorById(@PathVariable("id") int mId) {
		return mentorService.getMentorById(mId);
	}
	
	@GetMapping("getall")
	public List<MentorDto> getAllMentors(){
		return mentorService.getAll();
	}
}
