package cn.mylava._300._5_Socket._195_httpserver._7_reflect;

/**
 * comment: 将Servlet抽象为一个父类
 *
 * @author: lipengfei
 * @date: 2017/12/29
 */
public abstract class MyServlet {
    public void service(MyRequest request, MyResponse response) throws Exception {
        this.doGet(request,response);
        this.doPost(request,response);
    }
    //只有子类可以访问
    protected abstract void doGet(MyRequest request, MyResponse response) throws Exception;
    protected abstract void doPost(MyRequest request, MyResponse response) throws Exception;
}
