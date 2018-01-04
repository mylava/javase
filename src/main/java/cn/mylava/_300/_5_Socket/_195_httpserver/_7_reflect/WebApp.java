package cn.mylava._300._5_Socket._195_httpserver._7_reflect;

import cn.mylava._300._5_Socket._195_httpserver._7_reflect.sax.Entity;
import cn.mylava._300._5_Socket._195_httpserver._7_reflect.sax.Mapping;
import cn.mylava._300._5_Socket._195_httpserver._7_reflect.sax.WebappHanlder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/29
 */
public class WebApp {
    private static ServletContext context;

    //代码在加载时候将配置写入内存，不方便的是，每添加一个servlet都需要改变这个类 --> 可以考虑写入配置文件中
    static {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            WebappHanlder hanlder = new WebappHanlder();
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/mylava/_300/_5_Socket/_195_httpserver/_7_reflect/web.xml"),hanlder);

            context = new ServletContext();
            Map<String, String> servlet = context.getServlet();
            for (Entity entity : hanlder.getEntityList()) {
                servlet.put(entity.getName(),entity.getClazz());
            }

            Map<String, String> mapping = context.getMapping();
            for (Mapping map:hanlder.getMappingList()) {
                List<String> urls = map.getUrlPatterns();
                for (String url:urls) {
                    mapping.put(url,map.getName());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login.do", "login");
        mapping.put("/login", "login");
        mapping.put("/register", "register");

        Map<String, String> servlet = context.getServlet();
        servlet.put("login", "cn.mylava._300._5_Socket._195_httpserver._7_reflect.biz.LoginServlet");
        servlet.put("register", "cn.mylava._300._5_Socket._195_httpserver._7_reflect.biz.RegisterServlet");*/
    }

    public static MyServlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (null == url || "".equals(url = url.trim())) {
            return null;
        }

        String className = context.getServlet().get(context.getMapping().get(url));
        return (MyServlet) Class.forName(className).newInstance();
    }
}
