package cn.mylava._300._5_Socket._195_httpserver._5_dispatcher;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/29
 */
public class MyServlet {
    public void service(MyRequest request, MyResponse response) {
        response.buildContent("<html><body>");
        response.buildContent("欢迎："+request.decode(request.getParameter("name"),"utf-8")+"<br/>爱好是："+request.getParameter("box"));
        response.buildContent("</body></html>");
        response.completeContent();
    }
}
