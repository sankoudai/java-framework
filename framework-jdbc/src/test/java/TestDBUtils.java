import com.xulf.framework.jdbc.common.DBUtils;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : sankoudai
 * @version : created at 2015/9/16
 */
public class TestDBUtils extends TestCase {
    public void testGetConnection() throws SQLException {
        Connection connection = DBUtils.getConnection();
    }
}
