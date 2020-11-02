package com.uncleray.service;

import com.uncleray.dao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @author uncle
 * @create 2020/7/17 - 23:24
 */
@Service
public class DemoService {

    @Autowired
    PersonRepository repository;

    @Transactional
    public int updatePerson(Integer age, String name) {
        return repository.updatePersonByName(age, name);
    }
}
