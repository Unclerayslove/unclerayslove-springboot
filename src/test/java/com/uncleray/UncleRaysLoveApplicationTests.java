package com.uncleray;

import com.uncleray.web.dao.mapper.PersonMapper;
import com.uncleray.web.model.pojo.Person;
import com.uncleray.result.ResultCodeEnum;
import com.uncleray.web.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class UncleRaysLoveApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonServiceImpl personServiceImpl;

    @Test
    void myRepository() {
        Person person = new Person();
        person.setName("王妮");
        person.setAge(27);
        person.setSex('女');
        person.setGraduation("专科/无");
        person.setAddress("深圳市");
        personMapper.insert(person);
        ;
    }

    @Test
    void test() {

    }


    @Test
    void query() {


    }

    @Test
    void enumTest() {
        String success = ResultCodeEnum.SUCCESS.getMessage();
        System.out.println(success);
    }

}
