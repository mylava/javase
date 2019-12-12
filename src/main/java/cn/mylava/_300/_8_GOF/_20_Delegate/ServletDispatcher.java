package cn.mylava._300._8_GOF._20_Delegate;

import cn.mylava._300._8_GOF._20_Delegate.controller.MemberAction;
import cn.mylava._300._8_GOF._20_Delegate.controller.OrderAction;
import cn.mylava._300._8_GOF._20_Delegate.controller.SystemAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * comment: 模拟ServletDispatcher 委派
 *
 * @author: lipengfei
 * @date: 26/03/2018
 */
public class ServletDispatcher {
    //使用List模拟web.xml容器
    List<Handler> handlerList = new ArrayList<>();

    public ServletDispatcher() {
        Class<MemberAction> memberActionClass = MemberAction.class;
        Class<OrderAction> orderActionClass = OrderAction.class;
        Class<SystemAction> systemActionClass = SystemAction.class;
        try {
            handlerList.add(new Handler().
                    setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getMemberById", String.class))
                    .setUrl("/web/getMemberById.action")
            );
            handlerList.add(new Handler().
                    setController(orderActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getOrderById", String.class))
                    .setUrl("/web/getMemberById.action")
            );
            handlerList.add(new Handler().
                    setController(systemActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("logout", String.class))
                    .setUrl("/web/getMemberById.action")
            );
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatch(request, response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        //1.获取请求的URL
        String uri = request.getRequestURI();

        //2.拿到URL之后，判断委托给谁处理
        Handler handler = null;
        for (Handler h : handlerList) {
            if (h.getUrl().equals(uri)) {
                handler = h;
                break;
            }
        }
        //3.将具体任务分发给委托对象，通过反射调用委托对象方法
        Object obj = null;
        try {
            if (handler != null) {
                obj = handler.getMethod().invoke(handler.getController(), request.getParameter("id"));
            }

            //4.将处理结果返回
            response.getWriter().write(obj != null ? obj.toString() : "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
