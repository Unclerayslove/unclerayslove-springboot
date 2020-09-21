package com.uncleray.service;

import com.uncleray.dao.MyJpaRepository;
import com.uncleray.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author uncle
 * @create 2020/7/17 - 23:24
 */
@Service
public class DemoService {


    public String getkey() {
        return UUID.randomUUID().toString().substring(0,9);
    }
}
