package com.uncleray.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: uncle-ray
 * @description:
 * @author: lei pei
 * @create: 2020-11-03 21:51
 */
@Controller
public class LoginController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
