package com.uncleray.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uncleray.web.dao.mapper.AreaMapper;
import com.uncleray.web.model.pojo.Area;
import com.uncleray.web.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {
    @Autowired
    AreaService areaService;
    @Autowired
    AreaMapper areaMapper;

    @GetMapping("/counts/{address}")
    public long getAreaCount(@PathVariable String address) {
        return areaService.countArea(address);
    }

    @GetMapping("/areas/{start}/{end}")
    public List<Area> listAreas(@PathVariable Integer start, @PathVariable Integer end) {
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("area_id", start, end);
        List<Area> areaList = areaMapper.selectList(queryWrapper);
        return areaList;
    }

    @GetMapping("/area/{areaId}")
    public Area getArea(@PathVariable Integer areaId) {
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_id", areaId);
        Area area = areaMapper.selectOne(queryWrapper);
        return area;
    }
}
