package com.uncleray.web.controller;

import com.uncleray.web.model.query.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;


/**
 * @author uncle
 * @create 2020/7/17 - 23:20
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @GetMapping(value = "/users")
    @ApiOperation("查询用户接口")
    public User getUser(@ApiParam("key=value or ?username=value") String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

}
