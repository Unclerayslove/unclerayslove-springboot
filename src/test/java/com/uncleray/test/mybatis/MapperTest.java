package com.uncleray.test.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uncleray.web.dao.mapper.PersonMapper;
import com.uncleray.web.model.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @program: uncle-springboot
 * @description:
 * @author: lei pei
 * @create: 2020-11-28 22:39
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    PersonMapper personMapper;

    @Test
    void listPersons() {
        List<Person> people = personMapper.selectList();
    }

    @Test
    void getPerson() {
        // 必须给条件
        QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true, "name", "uncleRay");
        queryWrapper.eq(true, "age", 24);
        personMapper.selectOne(queryWrapper);
    }
}
