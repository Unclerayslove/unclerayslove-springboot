package com.uncleray.web.model.query;

import lombok.Data;

/**
 * @description:
 * @author: leipei
 * @create: 2020-12-09 23:51
 */
@Data
public class PersonPageReq {
    private Integer size;
    private Integer current;
    private Integer maxCurrent;
    private Integer total;

    public void setTotal(Integer total) {
        if (size != 0) {
            if (total % size != 0) {
                maxCurrent = total / size + 1;
            } else {
                maxCurrent = total / size;
            }
        }
        this.total = total;
    }

    public PersonPageReq() {

    }

    public PersonPageReq(Integer size, Integer current, Integer total) {
        this.size = size;
        this.current = current;
        this.total = total;
        setTotal(total);
    }
}
