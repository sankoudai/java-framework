package com.xulf.framework.jdbc.dao;

import com.xulf.framework.jdbc.common.DBUtils;
import com.xulf.framework.jdbc.domain.ExampleEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : sankoudai
 * @version : created at 2015/9/16
 */
public class ExampleEntityDao {
    /**
     * jdbc-insert： 流程
     * 1. 获取连接
     * 2. 创建语句执行语句
     * 3. 执行语句获得结果
     * 4. 关闭资源
     */
    public int insert(ExampleEntity entity) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        int rows = 0;
        try {
            con = DBUtils.getConnection();
            stmt = con.createStatement();

            String sql =
                            "insert into example_entity(username, password, name, gender, age, phone) values('%s', '%s', '%s', '%s', %d, '%s')";
            sql =
                            String.format(sql, entity.getUsername(), entity.getPassword(), entity.getName(), entity.getGender(), entity.getGender(), entity.getAge(), entity.getPhone());
            rows = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS); //影响的行数

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                entity.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(con, stmt, null);
        }

        return rows;
    }

    /**
     * 批量添加Emp对象到数据库中, 返回批量处理对应的结果
     * 流程：
     * 1. 建立连接
     * 2. 逐条建立语句， 并添加
     * 3. 执行
     * 4. 返回结果
     */
    public int[] insertByBatch(List<ExampleEntity> entities) {
        if (entities == null || entities.size() == 0) {
            return null;
        }

        String sql =
                        "insert into example_entity(username, password, name, gender, age, phone) values(?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        int[] results = null;
        try {
            con = DBUtils.getConnection();
            pstmt = con.prepareStatement(sql);

            for (ExampleEntity entity : entities) {
                pstmt.setString(1, entity.getUsername()); // 从1开始
                pstmt.setString(2, entity.getPassword());
                pstmt.setString(3, entity.getName());
                pstmt.setString(4, entity.getGender());
                pstmt.setObject(5, entity.getAge());
                pstmt.setString(6, entity.getPhone());
                pstmt.addBatch();
            }

            results = pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(con, pstmt, null);
        }

        return results;
    }

    /**
     * jdbc-select： 流程
     * 1. 获取连接 Connection
     * 2. 创建语句执行语句 Statement or PreparedStatement
     * 3. 执行语句获得结果集 ResultSet
     * 4. 遍历结果集获取数据
     * 5. 关闭资源
     * <p>
     * ResultSet 结构:
     * 只能用在查询中， 使用流程是next()将指针移动到下一行， 然后使用get方法获取这一行的数据. 具体如下:
     * next(): 将指针下移， 并且告诉我们这一行是否有数据， 没有下一行了返回false； 如果还有数据返回true, 将这行数据读取到内存中
     * getInt(n): 获取当前行的第n列, (从1开始)
     * getInt(fieldName): 获取当前行， 名为fieldName的列
     * getString: 用法同getInt, 获取字符串
     * getDate: 用法同getInt, 获取日期
     */
    public ExampleEntity selectById(Integer id) {
        if (id == null) {
            return null;
        }

        ExampleEntity entity = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select username, password, name, gender, age, phone from example_entity where id = ?";
            con = DBUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            /*获取滚动结果集*/
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = new ExampleEntity();
                entity.setId(id);
                entity.setUsername(resultSet.getString(1));
                entity.setPassword(resultSet.getString("password"));
                entity.setName(resultSet.getString("name"));
                entity.setGender(resultSet.getString("gender"));
                entity.setAge(resultSet.getInt("age"));
                entity.setPhone(resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(con, preparedStatement, resultSet);
        }

        return entity;
    }

    public List<ExampleEntity> findByRange(int startId, int endId) {
        List<ExampleEntity> exampleEntities = new ArrayList<ExampleEntity>();

        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try{
            String sql = "select id, username, password, name, gender, age, phone from example_entity where id BETWEEN ? and ?";

            con = DBUtils.getConnection();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, startId);
            psmt.setInt(2, endId);

            rs = psmt.executeQuery();
            while(rs.next()){
                ExampleEntity entity = new ExampleEntity();
                entity.setId(rs.getInt(1));
                entity.setUsername(rs.getString(2));
                entity.setPassword(rs.getString("password"));
                entity.setName(rs.getString("name"));
                entity.setGender(rs.getString("gender"));
                entity.setAge(parserInt(rs.getObject("age"))); //rs.getInt returns o for null
                entity.setPhone(rs.getString("phone"));
                exampleEntities.add(entity);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(con);
        }

        return exampleEntities;
    }

    /**
     * 事务执行流程:
     * 1. 建连接
     * 2. 设置提交 autoCommit=false
     * 3. 执行sql
     * 4. 恢复提交状态
     * 5. 处理异常(回滚)
     * 6. 关闭资源
     */
    public void executeInTransaction() {
        String sql1 = "update example_entity set age=1 where id =1";
        String sql2 = "update example_entity set age=2 where id =2";

        Connection con = null;
        Statement stmt = null;

        try {
            con = DBUtils.getConnection();
            stmt = con.createStatement();

            /* 不自动提交 */
            boolean autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);

            /*执行sql*/
            int rows1 = stmt.executeUpdate(sql1);
            int rows2 = stmt.executeUpdate(sql2);

            if (rows1 > 0 && rows2 > 0) {//成功提交
                con.commit();
                System.out.println("交易成功");
            } else {//失败回滚
                con.rollback();
                System.out.println("交易失败");
            }

            /*恢复提交方式*/
            con.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                System.out.println("回滚失败");
                e1.printStackTrace();
                Map map = null;
            }
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(con, stmt, null);
        }
    }


    /**
     * @param obj
     * @return null 如果obj 无法解析成合法的数字; 数字
     */
    private Integer parserInt(Object obj){
        if(obj == null){
            return null;
        }

        if(obj instanceof  Integer){
            return (Integer) obj;
        }

        try{
            return Integer.parseInt(obj.toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }
}
