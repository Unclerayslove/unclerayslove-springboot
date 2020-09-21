package com.uncleray.dao;

import com.uncleray.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author uncle
 * @create 2020/7/17 - 23:38
 */
//@Repository//这个注解可加可不加
public interface MyJpaRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

}
