package com.xulf.framework.mybatis.typehandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xulf.util.common.JsonUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuliufeng on 2016/1/21.
 */
public class MapTypeHandler extends BaseTypeHandler<Map<String, String>> {
    /**
     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型
     *
     * @param preparedStatement 当前的PreparedStatement对象
     * @param i                 当前参数的位置
     * @param parameter         当前参数的Java对象
     * @param jdbcType          当前参数的数据库类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Map<String, String> parameter, JdbcType jdbcType) throws SQLException {
        String json = JsonUtils.toJson(parameter);
        preparedStatement.setString(i, json);
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getMap(rs.getString(columnName));
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getMap(rs.getString(columnIndex));
    }

    @Override
    public Map<String, String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getMap(cs.getString(columnIndex));
    }

    private Map<String, String> getMap(String s) {
        if (s == null) {
            return null;
        }

        return JsonUtils.fromJson(s, new TypeReference<Map<String, String>>() {
        });
    }
}
