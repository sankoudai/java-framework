package com.xulf.framework.mybatis;

import com.xulf.framework.mybatis.domain.ExampleEntity;

import java.util.List;
import java.util.Map;

/**
 * 约定：
 * 1. 包名.接口名与ExampleEntityMapper.xml中定义的namespace需要一致
 * 2. 方法定义与ExampleEntityMap.xml中的条目保持一致：
 * 3. 方法名与条目id相同
 * 4. 参数类型使用parameterType指定类型
 * 5. 返回结果根据resultType选择单个对象， 或者集合
 *
 * @author : sankoudai
 * @version : created at 2015/9/14
 */
public interface ExampleMapper {

    /*--------------------- basic ---------------------*/
    /**
     * 方法名与ExampleEntityMapper.xml中的条目id相同，
     * 参数与条目的parameterType一致
     * @return 返回操作影响的行数
     */
    int insert(ExampleEntity exampleEntity);

    /**
     * @return 返回操作影响的行数
     */
    int updateById(ExampleEntity exampleEntity);

    /**
     * @return 返回操作影响的行数
     */
    int deleteById(Integer id);

    /**
     * @param id
     * @return 查询到的唯一对象
     */
    ExampleEntity selectById(Integer id);

    /**
     * @param id
     * @return 包含部分字段的map
     */
    Map selectBasicInfoById(Integer id);

    /**
     * @return 查询到的对象列表
     */
    List<ExampleEntity> selectAll();


    /**
     * 分页查询
     * @param pageInfo 分页信息， 要求包含offset, pageSize两个参数
     * @return
     */
    List<ExampleEntity> selectByPage_BadVersion(Map<String, Integer> pageInfo);

    /*--------------------- 高级查询  ---------------------*/
    List<ExampleEntity> selectByFilter(Map<String, Object> filter);
    List<ExampleEntity> selectByIds(List<Integer> ids);
    List<ExampleEntity> selectByKeys(List<ExampleEntity> entities);

    /**遍历map
     */
//    void batchUpdateAge(@Param("ageMap")Map<Integer, Integer> ageMap);
}
