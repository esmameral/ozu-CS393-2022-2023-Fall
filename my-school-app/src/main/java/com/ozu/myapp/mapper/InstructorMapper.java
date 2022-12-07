package com.ozu.myapp.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ozu.myapp.dto.InstructorDTO;
import com.ozu.myapp.model.Instructor;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorMapper INSTANCE = Mappers.getMapper( InstructorMapper.class ); 
    
    @Mapping(source = "roomNumber", target = "officeNumber")
    InstructorDTO instructorEntityToDTO(Instructor instructor); 
    
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courses", ignore = true)
    Instructor instructorDTOToEntity(InstructorDTO dto);
}
