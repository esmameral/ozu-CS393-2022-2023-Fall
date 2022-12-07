package com.ozu.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozu.myapp.dto.InstructorDTO;
import com.ozu.myapp.service.InstructorService;

@RestController()
@RequestMapping(value = "/instructors")
public class InstructorController {
	@Autowired
	InstructorService service;

		
	@GetMapping(value = "/{id}")
	public InstructorDTO findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<InstructorDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping
	public InstructorDTO save(@RequestBody InstructorDTO dto) {
		return service.save(dto);
	}

}
