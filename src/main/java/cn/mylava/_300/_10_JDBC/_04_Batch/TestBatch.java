package cn.mylava._300._10_JDBC._04_Batch;

import java.sql.*;

/**
 * comment: 批处理
 *
 * @author: lipengfei
 * @date: 06/02/2018
 */
public class TestBatch {
    public static void main(String[] args) {
        Connection conn=null;
        //因为预编译空间的问题，在批处理时使用Statement
        Statement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "root");

            //设置手动提交
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            //添加批处理
            for (int i = 0; i < 20; i++) {
                stmt.addBatch("insert into employees (last_name,email,dept_id) values ('zhang"+i+"','"+i+"@163.com',"+i+")");
            }

            stmt.executeBatch();

            conn.commit();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null) {
                    stmt.close();
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
