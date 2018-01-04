package cn.mylava._300._5_Socket._195_httpserver._6_myServlet;

import cn.mylava._300._5_Socket._195_httpserver._6_myServlet.biz.LoginServlet;
import cn.mylava._300._5_Socket._195_httpserver._6_myServlet.biz.RegisterServlet;

import java.util.Map;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/29
 */
public class WebApp {
    private static ServletContext context;
    static {
        context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login.do","login");
        mapping.put("/login","login");
        mapping.put("/register","register");

        Map<String, MyServlet> servlet = context.getServlet();
        servlet.put("login", new LoginServlet());
        servlet.put("register", new RegisterServlet());
    }

    public static MyServlet getServlet(String url) {
        if (null==url || "".equals(url=url.trim())) {
            return null;
        }

        return context.getServlet().get(context.getMapping().get(url));

    }
}
