package com.uncleray.service;

import com.uncleray.dao.repository.PersonRepository;
import com.uncleray.model.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public List<Person> getPersonList() {

        List<Person> all = repository.findAll();
        return all;
    }

    public void savePersons() {
        Person person = new Person();
        person.setName("王妮");
        person.setAge(27);
        person.setSex('女');
        person.setGraduation("专科/无");
        person.setAddress("深圳市");
        List<Person> list = new ArrayList<>();
        list.add(person);
        Person person1 = new Person();
        person1.setName("黑曼巴");
        person1.setAge(28);
        person1.setSex('男');
        person1.setGraduation("篮球/得分后卫");
        person1.setAddress("洛杉矶湖人队");
        list.add(person1);
        List<Person> list1 = repository.saveAll(list);
        System.out.println(list1);
    }

    public void deletePersons() {
        Person p1 = new Person();
        p1.setName("王妮");
        p1.setId(7);
        Person p2 = new Person();
        p2.setId(11);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        repository.deleteAll(list);

        System.out.println("删除成功");
    }

    public void deleteBatchPersons() {
        List<Integer> ids = new ArrayList<>();
        ids.add(12);
        ids.add(14);
        List<Person> allById = repository.findAllById(ids);
        repository.deleteInBatch(allById);
        System.out.println("删除成功");
    }

}
