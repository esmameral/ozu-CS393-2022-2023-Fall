package com.ozu.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ozu.myapp.model.Course;

@Component
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Course findByCode(String code) {
		String sql="SELECT * FROM T_COURSE WHERE CODE=?";
		return jdbcTemplate.queryForObject(sql, new CourseRowMapper(), code);
	}

	
	class CourseRowMapper implements RowMapper<Course> {
		   
		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course c = new Course();
			c.setId(rs.getInt("id"));
	        c.setCredit(rs.getInt("credit"));
	        c.setCode(rs.getString("code"));
	        c.setName(rs.getString("course_name"));
			return c;
		}
}
	
}
