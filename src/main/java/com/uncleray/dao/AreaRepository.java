package com.uncleray.dao;

import com.uncleray.entity.Area;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AreaRepository extends
        JpaRepository<Area, Integer>, JpaSpecificationExecutor<Area> {
    // JPQL查询,从from开始写
    // 按照位置传参
    @Query("from Area where address=?1 or areaId = ?2")
    List<Area> testAreas(String address, Integer areaId);

    // 对应传参
    @Query("from Area where address= :address and areaId = :areaId")
    Area oneAreas(@Param("address")String address, @Param("areaId") Integer areaId);

}
