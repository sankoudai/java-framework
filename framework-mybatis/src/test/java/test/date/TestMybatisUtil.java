package test.date;

import com.xulf.framework.mybatis.common.MybatisUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @author : sankoudai
 * @version : created at 2015/9/11
 */
public class TestMybatisUtil extends TestCase {
    public void testGetSqlSession() throws IOException {
        SqlSession sqlSession = MybatisUtil.openSqlSession();
        System.out.println(sqlSession);
        sqlSession.close();
    }
}
