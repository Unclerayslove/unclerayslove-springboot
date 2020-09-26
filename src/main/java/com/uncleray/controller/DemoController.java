package com.uncleray.controller;

import com.uncleray.pojo.User;
import com.uncleray.service.DemoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author uncle
 * @create 2020/7/17 - 23:20
 */
@RestController
@RequestMapping(path = "/api/v1")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/maps", method = RequestMethod.GET)
    public Map getMap() {
        Map map = new HashMap();
        map.put(demoService.getkey(), UUID.randomUUID());
        map.put(demoService.getkey(), UUID.randomUUID());
        map.put(demoService.getkey(), UUID.randomUUID());
        return map;
    }

    @PostMapping(value = "/strings")
    public UUID getString() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    @GetMapping(value = "/users")
    @ApiOperation("查询用户接口")
    public User getUser(@ApiParam("参数，格式为{data:[{key:value},{key:value}]}") String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }


}
