package com.uncleray;

import com.uncleray.dao.AreaRepository;
import com.uncleray.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootTest
public class AreaTest {
    @Autowired
    AreaRepository repository;

    static List<String> city = Arrays.asList("重庆", "成都", "北京", "上海", "杭州",
            "武汉", "西安", "广州", "深圳", "拉萨", "秀山");

    @Test
    void area() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            Area area = new Area();
            area.setParentId("parent_id" + UUID.randomUUID().toString().substring(0, 8));
            area.setParentName("parent_name" + UUID.randomUUID().toString().substring(0, 8));
            area.setProvinceId("province_id" + UUID.randomUUID().toString().substring(0, 8));
            area.setProvinceName("province_name" + UUID.randomUUID().toString().substring(0, 8));
            area.setAddress(city.get((int) (Math.random() * 10)));
            repository.save(area);
        }
        long end = System.currentTimeMillis();
        System.out.println("一共用时："+(end-start)/1000);
    }

    @Test
    void test() {
        Page<Area> all = repository.findAll(PageRequest.of(0,10));
        for (Area area : all) {
            System.out.println(area);
        }
    }
}
