package com.cg.adminservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.adminservice.dto.CourseDto;
import com.cg.adminservice.dto.MentorDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class Controller {

	private RestTemplate restTemplate;
	
	@GetMapping("getmentors")
	public ResponseEntity<List<MentorDto>> getMentorDetails() {
		List<MentorDto> mentorDtos  = Arrays.asList(restTemplate.getForObject("http://localhost:8087/mentor/getall", MentorDto[].class));
		
		return ResponseEntity.ok(mentorDtos);
		
	}
	
	@PostMapping("addmentor")
	public ResponseEntity<MentorDto> addMentorDetails(@RequestBody MentorDto mentorDto){
		return restTemplate.postForEntity("http://localhost:8087/mentor/add", mentorDto,MentorDto.class);
	}
	
	
	@GetMapping("getmentorById/{id}")
	public ResponseEntity<MentorDto> getMentorById(@PathVariable int id) {
		
		
		return restTemplate.getForEntity("http://localhost:8087/mentor/get/{id}",MentorDto.class,id);		
	}
	
	@GetMapping("getcourse")
	public ResponseEntity<List<CourseDto>> getAllCourse() {
		
		List<CourseDto> courseDtos = Arrays.asList(restTemplate.getForObject("http://localhost:8087/course/getall",CourseDto.class));
		return 	ResponseEntity.ok(courseDtos);	
	}
	
	@DeleteMapping("deletecourse/{id}")                          
	@ResponseStatus(HttpStatus.OK)
	public String deleteCourseById(@PathVariable int id) {
		restTemplate.delete("http://localhost:8087/course/delete/{id}",id);
		
		return 	"Deleted Course with Id"+id;	
	}
	
	
}
