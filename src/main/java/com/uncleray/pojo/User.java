package com.uncleray.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;

}
