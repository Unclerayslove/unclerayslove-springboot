package com.uncleray.test.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uncleray.web.dao.mapper.ToolMapper;
import com.uncleray.web.model.pojo.Tool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @program: uncle-springboot
 * @description:
 * @author: lei pei
 * @create: 2020-12-03 20:51
 */
@SpringBootTest
public class ToolTest {

    @Autowired
    ToolMapper toolMapper;

    @Test
    void tool() {
        Page<Tool> page = new Page<>(-1, 1);
        IPage<Tool> toolIPage = toolMapper.selectPage(page, null);
        System.out.println(toolIPage);
        System.out.println(toolIPage.getRecords());
    }
    @Test
    void selectByToolSeq(){
        Map<String, Object> map = toolMapper.selectByToolSeq(2);
        System.out.println(map);
    }
}
