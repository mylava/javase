package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/03/2018
 */
public class MyProxy {
    private static final String ln = "\r\n";
    public static Object newProxyInstance(MyClassLoader classLoader,Class<?>[] interfaces,MyInvocationHandler h) {
        /**
         * 1.动态生成源代码
         * 2.将Java文件输出到磁盘
         * 3.编译Java文件生成class文件
         * 4.加载class文件到JVM中
         * 5.返回字节码重组以后的代理对象
         */

        //1.动态生成源代码
        String s = generateSrc(interfaces);

        //2.将Java文件输出到磁盘
        File f = null;
        try {
            String path = MyProxy.class.getResource("").getPath();
            f = new File(path+"$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(s);
            fw.flush();
            fw.close();

        //3.编译Java文件生成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
        Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, javaFileObjects);
        task.call();
        manager.close();

        //4.加载class文件到JVM中
        Class<?> proxyClass = classLoader.findClass("$Proxy0");
        Constructor<?> constructor = proxyClass.getConstructor(MyInvocationHandler.class);

        //5.返回字节码重组以后的代理对象
        return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk;" + ln);
        sb.append("import " + interfaces[0].getName() +";"+ ln);
//        sb.append("import cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk.MyInvocationHandler;");
        sb.append("import java.lang.reflect.Method;"+ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("private MyInvocationHandler h;"+ln);
        sb.append("public $Proxy0(MyInvocationHandler h) {"+ln);
        sb.append("this.h=h;"+ln);
        sb.append("}"+ln);

        for (Method m:interfaces[0].getMethods()) {
            sb.append("public "+m.getReturnType().getName()+" "+ m.getName() + "() {"+ln);
            sb.append("try{"+ln);
            sb.append("Method m="+interfaces[0].getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
            sb.append("this.h.invoke(this,m,null);"+ln);
            sb.append("}catch(Throwable t){"+ln);
            sb.append("t.printStackTrace();"+ln);
            sb.append("}"+ln);
            sb.append("}"+ln);
        }

        sb.append("}"+ln);

        return sb.toString();
    }
}
