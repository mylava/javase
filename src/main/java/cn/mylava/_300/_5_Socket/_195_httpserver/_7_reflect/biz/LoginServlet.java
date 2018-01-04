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
public class LoginServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        if (login(name,pwd)) {
            response.println("登录成功");
        } else {
            response.println("登录失败");
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {

    }

    public boolean login(String name,String pwd) {
        return name.equals("name")&&pwd.equals("pwd");
    }

    public LoginServlet() {
    }
}
