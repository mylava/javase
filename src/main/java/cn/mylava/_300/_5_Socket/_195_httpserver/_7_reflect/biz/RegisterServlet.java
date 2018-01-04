package cn.mylava._300._5_Socket._195_httpserver._7_reflect.biz;

import cn.mylava._300._5_Socket._195_httpserver._7_reflect.MyRequest;
import cn.mylava._300._5_Socket._195_httpserver._7_reflect.MyResponse;
import cn.mylava._300._5_Socket._195_httpserver._7_reflect.MyServlet;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/29
 */
public class RegisterServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {

    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.buildContent("<html><body>");
        response.buildContent("注册成功，你的用户名为："+request.decode(request.getParameter("name"),"utf-8")+"<br/>");
        response.buildContent("</body></html>");
        response.completeContent();
    }
}
