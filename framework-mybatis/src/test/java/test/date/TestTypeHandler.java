package test.date;

import com.xulf.framework.mybatis.ExampleMapper;
import com.xulf.framework.mybatis.common.MybatisUtil;
import com.xulf.framework.mybatis.domain.ExampleEntity;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuliufeng on 2016/1/21.
 */
public class TestTypeHandler extends TestCase {
    public void testMapTypeHandler() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                ExampleEntity entity = example();
                mapper.insert(entity);
                sqlSession.commit();
                sqlSession.flushStatements();
                System.out.println(entity);


                ExampleEntity retrievedEntity = mapper.selectById(entity.getId());
                System.out.println(retrievedEntity);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }


    private ExampleEntity example() {
        ExampleEntity entity = new ExampleEntity();
        entity.setUsername("sankoudai");
        entity.setPassword("yun");

        Map<String, String> descMap = new HashMap<String, String>();
        descMap.put("home", "Henan");
        entity.setExtraDesc(descMap);

        return entity;
    }
}
