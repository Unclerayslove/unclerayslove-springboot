package com.uncleray.web.model.vo;

import com.uncleray.web.model.pojo.Person;
import lombok.Data;

/**
 * @description:
 * @author: leipei
 * @create: 2020-12-09 23:47
 */
@Data
public class PersonVO extends Person {
    private String address;
}
