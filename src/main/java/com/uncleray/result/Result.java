package com.uncleray.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: uncle-ray
 * @description: 可以用R/RR代替
 * @author: lei pei
 * @create: 2020-11-01 17:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code = 0;
    private String message = "success";
    private Object data = null;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = "nothing";
    }
}
