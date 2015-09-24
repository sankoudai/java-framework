package com.xulf.framework.mybatis.domain.date;

import java.util.Date;

/**
 * @author : sankoudai
 * @version : created at 2015/9/11
 */
public class DateTestEntity {
    private Integer id;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
