package com.uncleray;

import com.uncleray.model.pojo.Person;
import com.uncleray.result.ResultCode;
import com.uncleray.dao.repository.PersonRepository;
import com.uncleray.service.DemoService;
import com.uncleray.service.MyService;
import com.uncleray.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    PersonRepository repository;
    @Autowired
    PersonService personService;

    @Test
    void myRepository() {
        personService.deleteBatchPersons();
        Person person = new Person();
        person.setName("王妮");
        person.setAge(27);
        person.setSex('女');
        person.setGraduation("专科/无");
        person.setAddress("深圳市");
        Person save = repository.save(person);
        System.out.println(save);
        personService.savePersons();
    }

    @Test
    void delete() {
        personService.deleteBatchPersons();
    }

    @Autowired
    DemoService demoService;

    @Test
    void test() {
        List<Person> person = repository.testPerson("研究");
        System.out.println(person);
        int i = demoService.updatePerson(26, "雷佩");
        System.out.println(i);
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

    @Test
    void enumTest() {
        String success = ResultCode.SUCCESS.getMessage();
        System.out.println(success);
    }

}
