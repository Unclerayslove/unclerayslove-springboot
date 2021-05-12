package com.uncleray;

import com.uncleray.web.dao.mapper.PersonMapper;
import com.uncleray.web.model.pojo.Person;
import com.uncleray.result.ResultEnum;
import com.uncleray.web.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootTest
class UncleRaysLoveApplicationTests {

    public static void main(String[] args) {
        //常见函数式接口
        Consumer consumer = o -> System.out.println("Consumer函数式接口");
        String s = "qwerttyyui";
        Function<String,Integer> function = o -> o.length();
        System.out.println(function.apply(s));
    }

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
        String success = ResultEnum.SUCCESS.getMessage();
        System.out.println(success);
    }

}
