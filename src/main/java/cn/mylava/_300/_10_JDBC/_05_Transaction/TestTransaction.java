package cn.mylava._300._10_JDBC._05_Transaction;

import java.sql.*;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 07/02/2018
 */
public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "root");

            //设置手动提交
            conn.setAutoCommit(false);
            ps1 = conn.prepareStatement("insert into employees (last_name,email,dept_id) values (?,?,?)");
            ps1.setString(1, "lisi");
            ps1.setString(2, "lisi@163.com");
            ps1.setString(3, "6");
            ps1.execute();
            System.out.println("插入一个用户");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //故意将sql语句写错
            ps2 = conn.prepareStatement("insert into employees (last_name,email,dept_id) values (?,?,?,?)");
            ps2.setString(1, "wangwu");
            ps2.setString(2, "ww@163.com");
            ps2.setString(3, "6");
            ps2.execute();
            System.out.println("插入两个用户");

            conn.commit();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("发生错误，执行回滚");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
