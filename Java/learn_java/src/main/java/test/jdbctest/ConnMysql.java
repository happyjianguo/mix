package test.jdbctest;

import java.sql.*;

/**
 * Created by joshua on 17/3/11.
 */
public class ConnMysql {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("mysql driver error");
        }


        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "eleme", "eleme");
            // 使用Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
            }
            // 使用PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement("select * from user");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                System.out.println(rst.getInt(1) + "\t" + rst.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
