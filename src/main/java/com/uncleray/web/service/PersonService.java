package com.uncleray.web.service;

import com.uncleray.web.model.pojo.Person;

import java.util.List;

/**
 * A) Service/DAO 层方法命名规约
 * 1） 获取单个对象的方法用 get 做前缀。
 * 2） 获取多个对象的方法用 list 做前缀，复数结尾，如：listObjects。
 * 3） 获取统计值的方法用 count 做前缀。
 * 4） 插入的方法用 save/insert 做前缀。
 * 5） 删除的方法用 remove/delete 做前缀。
 * 6） 修改的方法用 update 做前缀。
 */
public interface PersonService {
    /**
     * 查询一个 get作前缀
     *
     * @return
     */
    Person getPerson();

    /**
     * 查询多个 list作前缀
     *
     * @return
     */
    List<Person> listPersons();
}
