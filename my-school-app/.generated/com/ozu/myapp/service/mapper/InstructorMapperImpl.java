package com.ozu.myapp.service.mapper;

import com.ozu.myapp.model.Instructor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T12:16:41+0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class InstructorMapperImpl implements InstructorMapper {

    @Override
    public InstructorDTO instructorEntityToDTO(Instructor instructor) {
        if ( instructor == null ) {
            return null;
        }

        String officeNumber = null;
        String name = null;

        officeNumber = instructor.getRoomNumber();
        name = instructor.getName();

        InstructorDTO instructorDTO = new InstructorDTO( name, officeNumber );

        return instructorDTO;
    }
}
