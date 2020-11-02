package com.uncleray.service.impl;

import com.uncleray.dao.repository.AreaRepository;
import com.uncleray.model.pojo.Area;
import com.uncleray.service.AreaService;
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
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository repository;

    @Override
    public long countArea(String address) {
        Specification<Area> specification = new Specification<Area>() {
            @Override
            public Predicate toPredicate(Root<Area> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate predicate = cb.equal(root.get("address"), root.get(""));
                predicates.add(predicate);
                Predicate and = cb.and(predicates.toArray(new Predicate[predicates.size()]));
                return and;
            }
        };

        long count = repository.count(specification);
        return count;
    }

}
