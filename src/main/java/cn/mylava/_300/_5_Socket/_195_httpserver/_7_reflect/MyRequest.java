package cn.mylava._300._5_Socket._195_httpserver._7_reflect;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/27
 */
public class MyRequest {
    //请求方式 get 和 post 传输数据位置不同
    private String method;
    //请求资源
    private String url;
    //请求参数 定义为list 因为html中同一个name的值可能是个列表  如checkbox
    private Map<String, List<String>> parameterMapValues;

    public static final String CRLF = "\r\n";

    private InputStream is;

    private String requestInfo;

    public MyRequest() {
        this.method = "";
        this.url = "";
        this.parameterMapValues = new HashMap<>();
        this.requestInfo = "";
    }

    public MyRequest(InputStream is) {
        this();
        this.is = is;
        try {
            byte[] data = new byte[20480];
            int len = is.read(data);
            requestInfo = new String(data, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            //请求信息读取失败，直接退出
            return;
        }
        //分析请求信息
        parseRequestInfo();
    }


//        GET /index?name=zhangsan&age=12 HTTP/1.1
//        Host: localhost:8888
//        Connection: keep-alive
//        User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36
//        Upgrade-Insecure-Requests: 1
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//        Accept-Encoding: gzip, deflate, br
//        Accept-Language: zh-CN,zh;q=0.9

    /**
     * 分析请求信息
     * =======================================
     * 1.从信息的首行分解出：请求方式、请求路径、请求参数(get方式才有)
     * <p>
     * <p>
     * <p>
     * <p>
     * =======================================
     */
    private void parseRequestInfo() {
        if (null == requestInfo || "".equals(requestInfo = requestInfo.trim())) {
            return;
        }
        //接收请求参数
        String paramsString = "";
        //获取第一行数据
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int index = requestInfo.indexOf("/");
        //获取请求方式
        this.method = firstLine.substring(0, index).trim();
        String urlStr = firstLine.substring(index, firstLine.indexOf("HTTP/")).trim();
        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramsString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else if (this.method.equalsIgnoreCase("get")) {
            if (urlStr.contains("?")) {
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramsString = urlArray[1];
            } else {
                this.url = urlStr;
            }
        }
        //将请求参数封装到map中
        System.out.println(Thread.currentThread().getName()+paramsString);
        if (!"".equals(paramsString)) {
            parseParams(paramsString);
        }


    }
    //将参数转为map
    private void parseParams(String paramsString) {
        //分割，将字符串转成数组
        StringTokenizer token = new StringTokenizer(paramsString,"&");
        while (token.hasMoreTokens()) {
            String keyValue = token.nextToken();
            String[] keyValues = keyValue.split("=");
            //如果参数值为空
            if (keyValue.length()==1) {
                keyValues = Arrays.copyOf(keyValues,2);
                keyValues[1] = null;
            }
            String key = keyValues[0].trim();
            String value = null==keyValues[1]?null:keyValues[1].trim();
            if (!parameterMapValues.containsKey(key)) {
                parameterMapValues.put(key,new ArrayList<String>());
            }

            List<String> values = parameterMapValues.get(key);
            values.add(value);
        }
    }

    /**
     * 根据页面的name获取对应的多个值
     * @param name
     * @return
     */
    public String[] getParameterValues(String name) {
        List<String>  values = null;
        if (null==(values=parameterMapValues.get(name))) {
            return null;
        } else {
            return values.toArray(new String[values.size()]);
        }
    }

    /**
     * 根据页面的name获取对应的单个值
     * @param name
     * @return
     */
    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        if (null==values) {
            return null;
        } else {
            return values[0];
        }
    }

    /**
     * 解码
     * @param value
     * @param code
     * @return
     */
    public String decode(String value,String code) {
        try {
            return URLDecoder.decode(value,code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
