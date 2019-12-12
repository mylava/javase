package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk;

import java.io.*;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/03/2018
 */
public class MyClassLoader extends ClassLoader {
    private File classPathFile;

    public MyClassLoader() {
        String classPath = MyClassLoader.class.getResource("").getPath();
        System.out.println(classPath);
        this.classPathFile = new File(classPath);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream is = null;
                ByteArrayOutputStream os = null;
                try {
                    is = new FileInputStream(classFile);
                    os = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = is.read(buff)) != -1) {
                        os.write(buff, 0, len);
                    }

                    Class<?> clazz = defineClass(className, os.toByteArray(), 0, os.size());
                    return clazz;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        if (null != os) {
                            os.close();
                        }
                        if (null != is) {
                            is.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }


        return null;
    }
}
