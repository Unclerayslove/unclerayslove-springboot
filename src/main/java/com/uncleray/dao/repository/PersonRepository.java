package com.uncleray.dao.repository;

import com.uncleray.model.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author uncle
 * @create 2020/7/17 - 23:38
 */
public interface PersonRepository extends
        JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
    //自定义 sql语句查询
    @Query(value = "select * from uncle_person where name=?1 and age=?2", nativeQuery = true)
    List<Person> testPerson(String name, int age);

    //直接写JPQL语句，按照位置传参，占位符传参，表明参数位置
    @Query("from Person where sex = ?1")
    List<Person> testPerson(Character sex);

    //按照名字传参 :xxxx   @Param("xxxx")
    @Query("from Person where graduation like %:graduation%")
    List<Person> testPerson(@Param("graduation") String graduation);

    //更新的SQL语句，不是JPQL语句 是原生的SQL语句，需要加上Modifying注解。并且需要添加事务处理
    @Modifying
    @Query(value = "update uncle_person as p set p.age = :age where p.name = :name", nativeQuery = true)
    int updatePersonByName(@Param("age") Integer age, @Param("name") String name);


}