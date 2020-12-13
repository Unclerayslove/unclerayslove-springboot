package com.uncleray.web.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uncleray.web.model.pojo.Person;
import com.uncleray.web.model.query.PersonPageReq;
import com.uncleray.web.model.vo.PersonVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PersonMapper extends BaseMapper<Person> {
    List<Person> selectPersons();

    List<PersonVO> getPersonPageList(Page<?> page, @Param("personPageReq") PersonPageReq personPageReq);
}
