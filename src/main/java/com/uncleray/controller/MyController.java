package com.uncleray.controller;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: uncle-ray
 * @description:
 * @author: lei pei
 * @create: 2020-10-14 23:00
 */
@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(Model model) {
        Map<String, Object> map = model.asMap();
        System.out.println(map);
        return map.toString();
    }

}
