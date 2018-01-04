package cn.mylava._300._5_Socket._195_httpserver._7_reflect.sax;

import java.util.ArrayList;
import java.util.List;

/**
 * comment: xml中Servlet-mapping对应的实体类
 *
 * @author: lipengfei
 * @date: 02/01/2018
 */
public class Mapping {
    private String name;
    private List<String> urlPatterns;


    public Mapping() {
        urlPatterns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(List<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }
}
