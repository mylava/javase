package cn.mylava._300._10_JDBC._02_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * comment: 测试Statement
 *
 * @author: lipengfei
 * @date: 06/02/2018
 */
public class TestStatement {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接(连接对象内部使用Socket对象进行通信，是一个远程连接，比较耗时)，真正开发中为了提高效率，都是用连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "root");
            //创建Statement
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES ('孙悟空','sun@163.com',2)";
            //执行sql
            statement.execute(sql);

            //测试sql注入
            String id = "5 or 1=1";
            String injection_sql = "update employees set dept_id=1 where id="+id;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
