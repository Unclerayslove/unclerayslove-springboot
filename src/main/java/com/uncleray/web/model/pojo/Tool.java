package com.uncleray.web.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @program: uncle-springboot
 * @description:
 * @author: lei pei
 * @create: 2020-12-03 20:45
 */
@Data
@TableName(value = "t_tool")
public class Tool {
    @TableId
    private Integer toolSeq;
    private String toolType;
    private String toolName;
    private String toolDesc;
    private Integer toolNum;
    private String validityBeginDate;
    private Integer validitDays;
    private Date createTime;
    private String toolStatus;
    private String acNo;

}
