package com.lihao.dao;

import com.lihao.bean.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDao {

    public void setDataSource(DataSource ds);

    public int create(Student student);

    public Student getStudent(Long id);

    public List<Student> listStudent();

    public int update(Student student);

    public int deleteStu(Long id);

}
