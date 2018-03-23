package cn.mylava._300._10_JDBC._06_Integrate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 07/02/2018
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = JDBCUtil.getConnection();

        String sql = "insert into employees (last_name,email,dept_id) values (?,?,?)";
        try {
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1,"zhaoliu");
                ps.setString(2,"zhaoliu@163.com");
                ps.setString(3,"8");
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(rs,ps,conn);
    }
}
