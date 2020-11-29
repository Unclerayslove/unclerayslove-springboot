package com.uncleray.web.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uncleray.web.model.pojo.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper extends BaseMapper<Person> {
    List<Person> selectList();
}
