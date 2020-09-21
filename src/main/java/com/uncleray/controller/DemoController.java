package com.uncleray.controller;

import com.uncleray.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author uncle
 * @create 2020/7/17 - 23:20
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/map")
    public Map getMap() {
        Map map = new HashMap();
        map.put(demoService.getkey(), UUID.randomUUID());
        map.put(demoService.getkey(), UUID.randomUUID());
        map.put(demoService.getkey(), UUID.randomUUID());
        return map;
    }


}
