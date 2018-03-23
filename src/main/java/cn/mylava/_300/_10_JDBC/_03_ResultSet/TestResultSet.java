package cn.mylava._300._10_JDBC._03_ResultSet;

import java.sql.*;

/**
 * comment: 测试ResultSet
 *
 * @author: lipengfei
 * @date: 06/02/2018
 */
public class TestResultSet {
    public static void main(String[] args) {
        Connection conn=null;
        Statement ps=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "root");
            //sql语句
            String sql = "select * from employees where id>5";
            ps = conn.createStatement();

            //提交sql
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1)+
                        "--lastName="+rs.getString(2)+
                        "--email="+rs.getString(3));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps!=null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
