package com.lihao;

import com.lihao.bean.Student;
import com.lihao.bean.User;
import com.lihao.dao.impl.StudentJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    private static ApplicationContext context;

    public static void main( String[] args )
    {
        context = new ClassPathXmlApplicationContext("classpath:SpringBean.xml");

        StudentJDBCTemplate jdbcTemplate = (StudentJDBCTemplate) context.getBean("studentJdbcTemplate");

        //query
        Student student = jdbcTemplate.getStudent(6L);
        System.out.println("查询一个");
        System.out.println(student);

        //create
//        Student s = new Student();
//        s.setName("libai");
//        s.setGender("男");
//        s.setDistance(12.4);
//        s.setAge(12);
//        s.setClass_id(3L);
//        int count = jdbcTemplate.create(s);
//        System.out.println("插入" + count);
//
        //querylist
//        List<Student> students = jdbcTemplate.listStudent();
//        System.out.println("查询所有");
//        System.out.println(students);
//
//        //update
//        Student ss = new Student();
//        ss.setId(5L);
//        ss.setName("test");
//        ss.setGender("男");
//        ss.setDistance(12.4);
//        ss.setAge(12);
//        ss.setClass_id(3L);
//        int update = jdbcTemplate.update(ss);
//        System.out.println("更新" + update);

        //delete
        int deleteStu = jdbcTemplate.deleteStu(5L);
        System.out.println("删除" + deleteStu);

//        //add
//        String addsql = "insert into t_user(`name`, age, birth) value(?, ?, ?)";
//        int count = jdbcTemplate.update(addsql, new Object[]{"dufu", 12, new Date()});

        //delete
//        String delsql = "delete from t_user where name = ?";
//        int count1 = jdbcTemplate.update(delsql, "dufu");

        //update
//        String update = "update t_user set name = ? where id = ?";
//        int count2 = jdbcTemplate.update(update, new Object[]{"wangwei", 111});

        //query
//        String querySql = "select * from t_user";
//        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<>(User.class);
//
//        User user = jdbcTemplate.queryForObject(querySql, userRowMapper);
//        System.out.println(user);

    }
}
