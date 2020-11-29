package com.uncleray.web.controller;

import com.uncleray.web.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    AreaService areaService;
//    @Autowired
//    AreaMapper areaMapper;

    @GetMapping("/counts/{address}")
    public long getAreaCount(@PathVariable String address) {
        return areaService.countArea(address);
    }

//    @GetMapping("/test")
//    public List<Area> getAreaCount() {
//        List<Area> areaList = areaMapper.selectList(null);
//        return areaList;
//    }
//
//    @GetMapping("/one")
//    public Area getAreaCount1() {
//        Area area = areaMapper.selectOne(null);
//        return area;
//    }
}
