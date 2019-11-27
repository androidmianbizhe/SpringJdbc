package com.lihao;

import com.lihao.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;

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

        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
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
        String querySql = "select * from t_user";
        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<>(User.class);

        User user = jdbcTemplate.queryForObject(querySql, userRowMapper);
        System.out.println(user);

    }
}
