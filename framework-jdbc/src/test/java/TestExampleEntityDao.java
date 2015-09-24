import com.xulf.framework.jdbc.dao.ExampleEntityDao;
import com.xulf.framework.jdbc.domain.ExampleEntity;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : sankoudai
 * @version : created at 2015/9/16
 */
public class TestExampleEntityDao extends TestCase{
    public void testInsert(){
        ExampleEntityDao dao = new ExampleEntityDao();

        ExampleEntity entity = new ExampleEntity();
        entity.setName("sankoudai");
        entity.setPassword("yun");
        dao.insert(entity);

        System.out.println(entity);
    }

    public void testSelectById(){
        ExampleEntityDao dao = new ExampleEntityDao();
        ExampleEntity entity = dao.selectById(1);
        System.out.println(entity);
    }

    public void testInsertByBatch(){
        ExampleEntity entity = new ExampleEntity();
        entity.setUsername("sankoudai");
        entity.setPassword("yun");

        List<ExampleEntity> entities = new ArrayList<ExampleEntity>();
        entities.add(entity);
        entities.add(entity);
        entities.add(entity);

        ExampleEntityDao dao = new ExampleEntityDao();
        int[] rowCounts = dao.insertByBatch(entities);
        System.out.println(rowCounts);
    }
}
