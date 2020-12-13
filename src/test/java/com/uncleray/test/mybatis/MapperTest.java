package com.uncleray.test.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uncleray.web.dao.mapper.PersonMapper;
import com.uncleray.web.model.pojo.Person;
import com.uncleray.web.model.query.PersonPageReq;
import com.uncleray.web.model.vo.PersonVO;
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
        PersonPageReq personPageReq = new PersonPageReq(5,1,0);
        Page<PersonVO> page = new Page<>(personPageReq.getCurrent(), personPageReq.getSize());
        List<PersonVO> personPageList = personMapper.getPersonPageList(page, personPageReq);
        for (PersonVO personVO : personPageList) {
            System.out.println(personVO.getName());
        }
        System.out.println(personPageList);
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
