package cn.mylava.test;

import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/11
 */
public class Test {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        String path ="/Users/lipengfei/Desktop/cgb/pkcs8_der.key";

        File file = new File(path);     //keyfile key文件的地址
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] tmpbuf = new byte[1024];
        int count = 0;
        while ((count = in.read(tmpbuf)) != -1) {
            bout.write(tmpbuf, 0, count);
            tmpbuf = new byte[1024];
        }
        in.close();

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bout.toByteArray());
        RSAPrivateKey privateKey = (RSAPrivateKey)keyFactory.generatePrivate(privateKeySpec);




    }

}
