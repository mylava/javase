package cn.mylava._300._8_GOF._18_Observer.event;

/**
 * comment: 模拟js实现给按钮添加事件监听
 * js添加事件监听代码如下：
 *  document.getElementById("myBtn").addEventListener("click", function(){
 *      document.getElementById("demo").innerHTML = "Hello World";
 *  });
 *
 * @author: lipengfei
 * @date: 02/04/2018
 */
public class Client {
    public static void main(String[] args) throws NoSuchMethodException {
        Mouse mouse = new Mouse(new MouseListener());
        //只给click方法添加了监听
        mouse.addListener(MouseEventType.ON_CLICK, new Target(),Target.class.getMethod("receive",MouseEvent.class));

        mouse.click();
        mouse.dbClick();
    }
}
