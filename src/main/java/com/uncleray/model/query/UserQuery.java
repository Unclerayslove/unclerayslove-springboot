package com.uncleray.model.query;

import lombok.Data;

/**
 * @ClassName UserQuery
 * @Description 数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。
 * @Author Leipei
 * @Date 2020/11/3 16:46
 * @Version V1.0
 **/
@Data
public class UserQuery {
    private String name;
    private Integer age;
    private String birthday;
}
