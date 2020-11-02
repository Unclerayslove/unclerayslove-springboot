package com.uncleray.controller;

import com.uncleray.dao.repository.AreaRepository;
import com.uncleray.model.pojo.Area;
import com.uncleray.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    AreaService areaService;
    @Autowired
    AreaRepository repository;

    @GetMapping("/counts/{address}")
    public long getAreaCount(@PathVariable String address) {
        return areaService.countArea(address);
    }

    @GetMapping("/test")
    public List<Area> getAreaCount() {
        List<Area> areaList = repository.testAreas("成都", 24);
        return areaList;
    }

    @GetMapping("/one")
    public Area getAreaCount1() {
        Area area = repository.oneAreas("北京", 24);
        return area;
    }
}
