package com.uncleray.web.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.IdType.*;

/**
 * @author uncle
 * @create 2020/7/17 - 23:37
 */
@Data
@TableName(value = "uncle_person")
public class Person implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private char sex;

    private String address;

    private String graduation;
}
