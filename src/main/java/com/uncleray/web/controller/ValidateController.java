package com.uncleray.web.controller;

import com.uncleray.web.model.query.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated//不能用在成员属性上
public class ValidateController {

    @PostMapping("/valid")
    public User test(@RequestBody @Valid List<User> users) {
        return users.get(0);
    }
}
