package com.xulf.framework.mybatis.mapper.date;

import com.xulf.framework.mybatis.domain.date.DateTestEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author : sankoudai
 * @version : created at 2015/9/11
 */
public interface DateTestEntityMapper {
    int insert(@Param("id")Integer id, @Param("date")Date date);
    int insert2(DateTestEntity dateTestEntity);
}
