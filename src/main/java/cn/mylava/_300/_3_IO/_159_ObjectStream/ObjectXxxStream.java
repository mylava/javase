package cn.mylava._300._3_IO._159_ObjectStream;

import java.io.*;
import java.util.Arrays;

/**
 * 对象的读写流
 *
 * @author lipengfei
 */
public class ObjectXxxStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObject("/Users/lipengfei/Desktop/data");
        readObject("/Users/lipengfei/Desktop/data");

    }

    /**
     * 将对象写入到文件中--->序列化
     * 当然也可以是流中
     */
    public static void writeObject(String destPath) throws IOException {
        //没有实现序列化接口：NotSerializableException
        Employee emp = new Employee("test", 10000);
        int[] arr = {1, 2, 3};

        //创建源
        File dest = new File(destPath);
        //选择流  DataOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );

        oos.writeObject(emp);
        oos.writeObject(arr);

        //释放资源
        oos.close();
    }

    /**
     * 从文件中读取对象--->反序列化
     *
     * @param srcPath
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readObject(String srcPath) throws IOException, ClassNotFoundException {
        File src = new File(srcPath);
        ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(src))
        );

        //操作 读取的顺序与写出一致   必须存在才能读取,否则：java.io.EOFException
        //不一致，数据存在问题
        Employee emp = (Employee) ois.readObject();
        int[] arr = (int[]) ois.readObject();
        ois.close();
        //打印结果看到transient属性值为null
        System.out.println(emp);
        System.out.println(Arrays.toString(arr));
    }
}
