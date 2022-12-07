package com.ozu.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ozu.myapp.model.Student;
@Component
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Student findById(int id) {
		String sql="SELECT * FROM T_STUDENT WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
	}

	@Override
	public void save(Student aStudent) {
		// TODO Auto-generated method stub

	}
	class StudentRowMapper implements RowMapper<Student> {
		   
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
	        student.setName(rs.getString("name"));
	        student.setDepartment(rs.getString("department"));
			return student;
		}
}
}
