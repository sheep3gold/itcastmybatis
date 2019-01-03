package cn.itcast.jdbc;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///heima";
            String user = "root";
            String password = "admin";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from tb_user where id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, 1L);
            rs = psmt.executeQuery();
            while (rs.next()) {
                System.out.println("id=" + rs.getLong("id"));
                System.out.println("name=" + rs.getString("name"));
                System.out.println("passwd=" + rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != psmt) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
