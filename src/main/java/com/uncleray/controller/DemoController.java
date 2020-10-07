package com.uncleray.controller;

import com.uncleray.dao.MyJpaRepository;
import com.uncleray.entity.Person;
import com.uncleray.pojo.User;
import com.uncleray.service.DemoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    MyJpaRepository repository;
    @Autowired
    EntityManager entityManager;

    @RequestMapping(value = "/maps", method = RequestMethod.GET)
    public Map getMap() {
        Map map = new HashMap();
        map.put(demoService.getkey(), UUID.randomUUID());
        map.put(demoService.getkey(), UUID.randomUUID());
        map.put(demoService.getkey(), UUID.randomUUID());
        return map;
    }

    @GetMapping("/strings")
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

    @GetMapping("/persons")
    public List<Person> getPersonList(@RequestBody Map<String, Integer> request) {
        Pageable pageable = PageRequest.of(request.get("page"), request.get("size"));
        //定制SQL，entityManager就相当于sqlSession，用来操作数据库
        String sql = "select * from uncle_person";
        Query query = entityManager.createNativeQuery(sql, Person.class);
        List list = query.getResultList();
        System.out.println(list);
        return repository.findAll(pageable).getContent();
    }


}
