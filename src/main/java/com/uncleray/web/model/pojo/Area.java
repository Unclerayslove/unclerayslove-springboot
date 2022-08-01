package com.uncleray.web.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "area")
public class Area implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer areaId;
    private String provinceId;
    private String provinceName;
    private String address;
    private String parentId;
    private String parentName;

}
