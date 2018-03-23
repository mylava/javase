package cn.mylava._300._10_JDBC._01_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * comment: 创建JDBC连接
 *
 * @author: lipengfei
 * @date: 06/02/2018
 */
public class CreateConnection {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接(连接对象内部使用Socket对象进行通信，是一个远程连接，比较耗时)，真正开发中为了提高效率，都是用连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "root");
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
