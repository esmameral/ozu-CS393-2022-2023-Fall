package com.ozu.myapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.dto.InstructorDTO;
import com.ozu.myapp.mapper.InstructorMapper;
import com.ozu.myapp.model.Instructor;
import com.ozu.myapp.repository.InstructorRepository;

@Service
public class InstructorService {
	

	@Autowired
	InstructorRepository instructorRepository;

	
    @Autowired
    InstructorMapper instructorMapper;
    
    public InstructorDTO save(InstructorDTO dto) {
    	Instructor ins=instructorMapper.instructorDTOToEntity(dto);
    	instructorRepository.save(ins);
    	return instructorMapper.instructorEntityToDTO(ins);
    }
	public InstructorDTO findById(int id) {
		Optional<Instructor> opt= instructorRepository.findById(id);
		if(opt.isPresent()) {
			Instructor ins =opt.get();
			System.out.println(ins);
			return instructorMapper.instructorEntityToDTO(ins);
		}
		return null;
	}
	public List<InstructorDTO> findAll() {
		List<Instructor> list= instructorRepository.findAll();
		List<InstructorDTO> dtoList= new ArrayList<>();
		for (Instructor instructor : list) {
			dtoList.add(instructorMapper.instructorEntityToDTO(instructor));
		}
			
		return dtoList;
	}
	public InstructorRepository getInstructorRepository() {
		return instructorRepository;
	}

	public void setInstructorRepository(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}

	

}
