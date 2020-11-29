package com.uncleray.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uncleray.web.dao.mapper.PersonMapper;
import com.uncleray.web.model.pojo.Person;
import com.uncleray.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person getPerson() {
        // 必须给条件
        QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true, "name", "uncleRay");
        queryWrapper.eq(true, "age", 24);
        return personMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Person> listPersons() {
        return personMapper.selectList();
    }
}
