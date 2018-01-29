package cn.mylava._300._7_JVM._02_ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * comment: 自定义文件系统类加载器
 *
 * @author: lipengfei
 * @date: 08/01/2018
 */
public class MyClassLoader extends ClassLoader {
    //此加载器默认读取的目录
    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
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
        String path = rootDir+"/"+classname.replace(".","/")+".class";

        FileInputStream is = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            is = new FileInputStream(path);
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
