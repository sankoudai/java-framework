package test.date;

import com.xulf.framework.mybatis.ExampleMapper;
import com.xulf.framework.mybatis.common.MybatisUtil;
import com.xulf.framework.mybatis.domain.ExampleEntity;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.*;

/**
 * @author : sankoudai
 * @version : created at 2015/9/15
 */
public class TestExampleMapper extends TestCase {
    public void testInsert() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                ExampleEntity entity = new ExampleEntity();
                entity.setUsername("sankoudai");
                entity.setPassword("yun");
                mapper.insert(entity);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entity);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }


    public void testUpdateById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                ExampleEntity entity = new ExampleEntity();
                entity.setId(1);
                entity.setUsername("sankoudai");
                entity.setPassword("yun");
                entity.setGender("male");

                mapper.updateById(entity);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entity);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testSelectById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                ExampleEntity entity = mapper.selectById(2);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entity);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testSelectBasicInfoById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                Map entityInfo = mapper.selectBasicInfoById(2);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entityInfo);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testSelectAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                List<ExampleEntity> entities = mapper.selectAll();
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entities);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testSelectByPage_BadVersion(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                Map<String, Integer> pageInfo = new HashMap<String, Integer>();
                pageInfo.put("offset", 0);
                pageInfo.put("pageSize", 3);
                List<ExampleEntity> entities = mapper.selectByPage_BadVersion(pageInfo);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entities);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }
    
    public void testSelectByFilter(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                Map<String, Object> filter = new HashMap<String, Object>();
                filter.put("username", "sankoudai");
                filter.put("gender", "male");
                List<ExampleEntity> entities = mapper.selectByFilter(filter);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entities);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }


    public void testSelectByIds(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                List<Integer> ids = Arrays.asList(1, 2);
                List<ExampleEntity> entities = mapper.selectByIds(ids);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entities);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testSelectByKeys(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                ExampleEntity entity1 = new ExampleEntity();
                entity1.setId(1);

                ExampleEntity entity2 = new ExampleEntity();
                entity2.setId(2);

                List<ExampleEntity> conditionEntities = Arrays.asList(entity1, entity2);
                List<ExampleEntity> entities = mapper.selectByKeys(conditionEntities);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entities);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testSelectMiddleAges(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);

            if (mapper != null) {
                ExampleEntity older = new ExampleEntity();
                older.setAge(10);

                ExampleEntity younger = new ExampleEntity();
                younger.setAge(25);

                List<ExampleEntity> entities = mapper.selectMiddleAges(older, younger);
                sqlSession.commit();
                sqlSession.flushStatements();

                System.out.println(entities);
            } else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }
}
