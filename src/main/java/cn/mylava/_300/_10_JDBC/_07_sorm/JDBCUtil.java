package cn.mylava._300._10_JDBC._07_sorm;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * comment: JDBC整合工具类
 *
 * @author: lipengfei
 * @date: 07/02/2018
 */
public class JDBCUtil {
    static Properties pros = null;
    //只需要读取一次，所以用静态块进行处理
    static {
        pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/mylava/_300/_10_JDBC/_06_Integrate/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        try {
            Class.forName(pros.getProperty("mysql.driver"));
            return DriverManager.getConnection(pros.getProperty("mysql.url"),pros.getProperty("mysql.user"),pros.getProperty("mysql.pwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, Statement stmt,Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
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
