package com.uncleray.service;

import com.uncleray.dao.MyJpaRepository;
import com.uncleray.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    @Autowired
    MyJpaRepository repository;

    public List<Person> findSearch(Person model) {

        List<Person> result = repository.findAll(new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                System.out.println("Root<Person>:"+root);
                System.out.println("CriteriaQuery<?>:"+query);
                System.out.println("CriteriaBuilder:"+cb);

//                System.out.println(model.getAge());
//                list.add(cb.equal(root.get("age").as(Integer.class), model.getAge()));
//
//                System.out.println(model.getName());
//                list.add(cb.equal(root.get("name").as(String.class), model.getName()));

                System.out.println(model.getAddress());
                if (model.getGraduation() != null && !model.getGraduation().equals("")) {
                    list.add(cb.equal(root.get("graduation").as(String.class), model.getGraduation()));
                }

                System.out.println(root.get("address"));
                if (model.getAddress() != null && !model.getAddress().equals("")) {
                    list.add(cb.like(root.get("address").as(String.class), "%" + model.getAddress() + "%"));
                }

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        });

        return result;
    }
}
