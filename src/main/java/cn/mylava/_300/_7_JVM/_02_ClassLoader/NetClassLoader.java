package cn.mylava._300._7_JVM._02_ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * comment: 自定义网络类加载器
 *
 * @author: lipengfei
 * @date: 08/01/2018
 */
public class NetClassLoader extends ClassLoader {
    //此加载器默认读取的目录
    private String rootUrl;

    public NetClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //先查询已经加载的类
        Class<?> c = findLoadedClass(name);
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }
            if (c != null) {
                return c;
            }else {
                //类文件的二进制流
                byte[] classData = getClassData(name);
                if (classData==null) {
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }

        return c;
    }

    private byte[] getClassData(String classname) {
        String path = rootUrl +"/"+classname.replace(".","/")+".class";

        InputStream is = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            URL url = new URL(path);
            is = url.openStream();
            byte[] buffer = new byte[1024];
            int offset = 0;
            while ((offset=is.read(buffer)) !=-1) {
                bos.write(buffer,0,offset);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
