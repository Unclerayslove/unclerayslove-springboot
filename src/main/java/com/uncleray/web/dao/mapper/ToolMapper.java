package com.uncleray.web.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uncleray.web.model.pojo.Tool;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ToolMapper extends BaseMapper<Tool> {
    Map<String, Object> selectByToolSeq(Integer toolSeq);
}
