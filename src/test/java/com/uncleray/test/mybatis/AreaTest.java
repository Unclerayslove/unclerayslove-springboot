package com.uncleray.test.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uncleray.web.dao.mapper.AreaMapper;
import com.uncleray.web.model.pojo.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @program: uncle-springboot
 * @description:
 * @author: lei pei
 * @create: 2020-11-30 22:15
 */
@SpringBootTest
public class AreaTest {
    @Autowired
    AreaMapper areaMapper;

    @Test
    void findByCondition() {
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("address", "成都");//like %?%
        queryWrapper.likeLeft("address", "11");//like %? 以xxx结尾
//        queryWrapper.likeRight("address","重庆");//like ?% 以xxx开头
        areaMapper.selectList(queryWrapper);
    }

    @Test
    void pagination() {
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
        Page<Area> page = new Page<>();
        areaMapper.selectPage(page, queryWrapper);
    }

    @Test
    void mapForEach() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uncle", "ray");
        hashMap.put("kobe", "bryant");

        hashMap.forEach((k, v) -> System.out.println(k + "---" + v));

    }
}
