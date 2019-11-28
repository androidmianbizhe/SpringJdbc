package com.lihao.mapper;

import com.lihao.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setAge(resultSet.getInt("age"));
        student.setDistance(resultSet.getDouble("distance"));
        student.setGender(resultSet.getString("gender"));
        student.setName(resultSet.getString("name"));
        student.setClass_id(resultSet.getLong("class_id"));

        return student;
    }
}
