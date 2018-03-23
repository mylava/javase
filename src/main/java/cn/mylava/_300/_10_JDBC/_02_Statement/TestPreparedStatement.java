package cn.mylava._300._10_JDBC._02_Statement;

import java.sql.*;

/**
 * comment: 测试PreparedStatement
 *
 * @author: lipengfei
 * @date: 06/02/2018
 */
public class TestPreparedStatement {
    public static void main(String[] args) {
        try {
            //
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接(连接对象内部使用Socket对象进行通信，是一个远程连接，比较耗时)，真正开发中为了提高效率，都是用连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "root");
            //sql语句
            String sql = "insert into employees (last_name,email,dept_id) values (?,?,?)";
            //创建PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"zhangsan");
            ps.setString(2,"zs@163.com");
            ps.setString(3,"6");
            //提交执行
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
