package cn.mylava._300._5_Socket._195_httpserver._7_reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * comment: Servlet上下文环境,对应tomcat 的web.xml中的配置
 *
 * @author: lipengfei
 * @date: 2017/12/29
 */
public class ServletContext {
    //为每一个servlet取一个别名 如 login --> LoginServlet
    private Map<String,String> servlet;
    //映射  url --> login 因为 一个servlet可能有多个url对应，所以新建一个map
    //如果映射直接存储url-->servlet，因为servlet对象较大且可能有多个，占用内存会比较多，所以采用url-->servlet别名
    private Map<String,String> mapping;

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
