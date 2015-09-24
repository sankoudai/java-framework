package test.date;

import com.xulf.framework.mybatis.common.MybatisUtil;
import com.xulf.framework.mybatis.domain.date.DateTestEntity;
import com.xulf.framework.mybatis.mapper.date.DateTestEntityMapper;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;

/**
 * @author : sankoudai
 * @version : created at 2015/9/11
 */
public class TestDateTestEntityMapper extends TestCase {
    public void testInsert(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            DateTestEntityMapper mapper = sqlSession.getMapper(DateTestEntityMapper.class);

            if(mapper != null){
                mapper.insert(0, new Date());
                sqlSession.commit();
                sqlSession.flushStatements();
            }else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    public void testInsert2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSqlSession();
            DateTestEntityMapper mapper = sqlSession.getMapper(DateTestEntityMapper.class);

            if(mapper != null){
                DateTestEntity entity = new DateTestEntity();
                entity.setId(2);
                entity.setCreateDate(new Date());
                mapper.insert2(entity);
                sqlSession.commit();
                sqlSession.flushStatements();
            }else {
                System.out.println("mapper is null!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }
}
