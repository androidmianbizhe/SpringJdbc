package com.lihao.dao.impl;

import com.lihao.bean.Student;
import com.lihao.dao.StudentDao;
import com.lihao.mapper.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDao {

    private DataSource  dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Student student) {
        String sql = "insert into t_student (`name`, age, distance, gender, class_id) values (?, ?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge(), student.getDistance(), student.getGender(), student.getClass_id()});
        return update;
    }

    @Override
    public Student getStudent(Long id) {

        String sql = "select * from t_student where id = ?";
        return jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
    }

    @Override
    public List<Student> listStudent() {
        String sql = "select * from t_student";
        List<Student> query = jdbcTemplate.query(sql, new StudentMapper());
        return query;
    }

    @Override
    public int update(Student student) {

        String sql = "update t_student set name = ?, gender = ?, distance = ?, age = ?, class_id = ? where id = ?";
        return jdbcTemplate.update(sql, new Object[]{student.getName(),student.getGender(),
                student.getDistance(), student.getAge(), student.getClass_id(), student.getId()});
    }

    @Override
    public int deleteStu(Long id) {
        String delSql = "delete from t_student where id = ?";
        return jdbcTemplate.update(delSql, new Object[]{id});
    }
}
