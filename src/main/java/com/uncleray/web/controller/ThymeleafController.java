package com.uncleray.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName ThymeleafController
 * @Description
 * @Author Leipei
 * @Date 2020/11/3 17:43
 * @Version V1.0
 **/
@Controller
public class ThymeleafController {
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("uid", UUID.randomUUID().toString().substring(0, 8));
        model.addAttribute("name", "unclerayslove");
        return "show";
    }
}
