package com.uncleray.controller;

import com.uncleray.dao.repository.PersonRepository;
import com.uncleray.model.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

/**
 * @author uncle
 * @create 2020/7/17 - 23:20
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    PersonRepository repository;
    @Autowired
    EntityManager entityManager;

    @GetMapping(value = "/users")
    @ApiOperation("查询用户接口")
    public User getUser(@ApiParam("key=value or ?username=value") String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

}
