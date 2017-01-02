package test.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by joshua on 17/1/2.
 */
public class HikaricpTest {

    private HikariDataSource ds;

    public void init(int minimum, int maximum) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?user=eleme&password=eleme&useUnicode=true&characterEncoding=utf8");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 500);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.setConnectionTestQuery("SELECT 1");
        config.setAutoCommit(true);
        config.setMinimumIdle(minimum);
        config.setMaximumPoolSize(maximum);
        ds = new HikariDataSource(config);
    }

    public void shutdown() {
        ds.shutdown();
    }

    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            ds.close();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        HikaricpTest hikaricpTest = new HikaricpTest();
        // three methods to get class
        System.out.println(hikaricpTest.getClass());
        System.out.println(HikaricpTest.class);
        try {
            System.out.println(Class.forName("test.hikaricp.HikaricpTest"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        hikaricpTest.init(10, 50);
        Connection conn = hikaricpTest.getConnection();
        String sql = "select * from user";
        PreparedStatement psm = conn.prepareStatement(sql);
        ResultSet rs = psm.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }

        conn.close();
    }
}
