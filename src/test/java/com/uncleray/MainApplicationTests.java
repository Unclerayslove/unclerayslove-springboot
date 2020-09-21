package com.uncleray;

import com.uncleray.dao.MyJpaRepository;
import com.uncleray.entity.Person;
import com.uncleray.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class MainApplicationTests {

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
    MyJpaRepository repository;

    @Test
    void myRepository() {
        Person person = new Person();
        person.setName("刘亦菲");
        person.setAge(23);
        person.setSex('女');
        person.setGraduation("研究生/硕士");
        person.setAddress("重庆市");
        Person save = repository.save(person);
        System.out.println(save);
    }

    @Autowired
    MyService service;
    @Test
    void query() {

//        Optional<Person> person = repository.findById(1);
//        System.out.println(person.get());
//
//        long count = repository.count();
//        System.out.println(count);
//
//        Person one = repository.getOne(2);
//        System.out.println(one);

        Person model = new Person();
        model.setAge(26);
        model.setName("雷佩");
        model.setAddress("四川");
        List<Person> search = service.findSearch(model);
//        System.out.println(search);
        for (Person person : search) {
            System.out.println(person);
        }

    }

}
