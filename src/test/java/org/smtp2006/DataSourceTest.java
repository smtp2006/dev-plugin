package org.smtp2006;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class DataSourceTest extends SpringTest {
    @Autowired
    DataSource ds;

    @Test
    public void testDataSource() throws SQLException {
        Assert.notNull(ds);
        Connection con = ds.getConnection();
        Assert.notNull(con);
        con.close();
    }
}
