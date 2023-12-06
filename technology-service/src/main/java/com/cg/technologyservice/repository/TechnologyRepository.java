package com.cg.technologyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.technologyservice.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

	Technology findByTechnologyCode(String technologyCode);
}
