package com.ozu.myapp.service.mapper;

import com.ozu.myapp.model.Course;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T12:16:41+0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO instructorEntityToDTO(Course c) {
        if ( c == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setName( c.getName() );
        courseDTO.setCode( c.getCode() );
        courseDTO.setCredit( c.getCredit() );

        return courseDTO;
    }
}
