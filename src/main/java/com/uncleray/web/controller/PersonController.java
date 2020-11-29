package com.uncleray.web.controller;

import com.uncleray.web.dao.mapper.PersonMapper;
import com.uncleray.web.model.pojo.Person;
import com.uncleray.web.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Person接口
 */
@RestController
public class PersonController {

    @Autowired
    PersonServiceImpl service;

    @Autowired
    PersonMapper personMapper;


    @GetMapping("/persons")
    public List<Person> getPersons() {
        return service.listPersons();
    }

    @GetMapping("person")
    public Person getPerson() {
        return service.getPerson();
    }

    /**
     * 根据id查询person
     *
     * @param id person的Id
     * @return
     */
    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        return personMapper.selectById(id);
    }

}
