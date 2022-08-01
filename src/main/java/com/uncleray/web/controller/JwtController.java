package com.uncleray.web.controller;

import com.uncleray.result.ApiResult;
import com.uncleray.util.JWTUtils;
import com.uncleray.web.model.query.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: uncle-springboot
 * @description:
 * @author: lei pei
 * @create: 2020-11-29 21:32
 */
@RestController
public class JwtController {

    @PostMapping("/user/login")
    public ApiResult login(@RequestBody User user) {
        String token = JWTUtils.sign(user);
        return new ApiResult(200, "登录成功", token);
    }
}
