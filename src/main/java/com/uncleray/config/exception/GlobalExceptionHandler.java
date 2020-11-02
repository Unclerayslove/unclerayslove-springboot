package com.uncleray.config.exception;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: uncle-ray
 * @description: 全局异常处理
 * @author: lei pei
 * @create: 2020-10-14 22:53
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ModelAttribute
    public Map<String, Object> myData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }

}
