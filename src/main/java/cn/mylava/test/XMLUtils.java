package cn.mylava.test;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/04/2018
 */
public class XMLUtils {

    public static Map<String, Object> xmlParse(String xml, String encoding) throws XmlPullParserException, IOException {
        Map<String, Object> map = new HashMap<>();
        Map<String, String> head = null;
        Map<String, Object> body = null;
        List<Map<String,String>> frames = new ArrayList<>();
        Map<String, String> frame = null;

        String condition = null;
        if (null!=xml && !"".equals(xml)) {
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
            XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
            pullParser.setInput(inputStream, encoding); // 为xml设置要解析的xml数据
            int eventType = pullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        String key = pullParser.getName();
                        if (key.equals("Out")) {
                            break;
                        } else if (key.equals("Head")) {
                            head = new HashMap<>();
                            condition = key;
                            break;
                        } else if (key.equals("Body")) {
                            body = new HashMap<>();
                            condition = key;
                            break;
                        } else if (key.equals("Frame")) {
                            frame = new HashMap<>();
                            condition = key;
                            break;
                        }
                        System.out.println(key);
                        String value = pullParser.nextText().trim();
                        if (condition!=null && "Head".equals(condition)) {
                            head.put(key, value);
                        } else if (condition!=null && "Body".equals(condition)) {
                            body.put(key,value);
                        } else if (condition!=null && "Frame".equals(condition)) {
                            frame.put(key,value);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        String endKey = pullParser.getName();
                        if (endKey.equals("Head")) {
                            map.put(endKey,head);
                        } else if (endKey.equals("Body")) {
                            map.put(endKey,body);
                            map.put("Frames",frames);
                            break;
                        } else if (endKey.equals("Frame")) {
                            frames.add(frame);
                            break;
                        }
                        break;
                }
                eventType = pullParser.next();
            }

        }
        return map;
    }

    public static void main(String[] args) {

        StringBuilder message = new StringBuilder("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?><Out>");
        message.append("<Head>")
        .append("<ChnlNo>").append(1).append("</ChnlNo>")
        .append("<FTranCode>").append(2).append("</FTranCode>")
        .append("<InstID>").append(3).append("</InstID>")
        .append("<TrmSeqNum>").append(4).append("</TrmSeqNum>")
        .append("<ErrCode>").append(5).append("</ErrCode>")
        .append("</Head>")
        .append("<Body><operationDate>").append(6).append("</operationDate>")
        .append("<Frame>")
        .append("<bank>").append("银行1").append("</bank>")
        .append("<bankNum>").append("银行卡号2").append("</bankNum>")
        .append("</Frame>")
        .append("<Frame>")
        .append("<bank>").append("银行1").append("</bank>")
        .append("<bankNum>").append("银行卡号2").append("</bankNum>")
        .append("</Frame>")
        .append("</Body>")
        .append("</Out>");
        String xml = message.toString();

        System.out.println(xml);

        try {
            Map<String, Object> map = xmlParse(xml, "ISO-8859-1");
            System.out.println("============Head============");
            for (Map.Entry<String,String > entry:((Map<String,String >)map.get("Head")).entrySet()) {
                System.out.println(entry.getKey()+"-------"+entry.getValue());
            }

            System.out.println("============Body============");
            for (Map.Entry<String,String> entry:((Map<String,String >)map.get("Body")).entrySet()) {
                System.out.println(entry.getKey()+"-------"+entry.getValue());
            }

            System.out.println("============Frames============");
            for (Map<String,String> frame:(List<Map<String,String>>)map.get("Frames")) {
                for (Map.Entry<String, String> entry : frame.entrySet()) {
                    System.out.println(entry.getKey() + "-------" + new String(entry.getValue().getBytes("ISO-8859-1"), "utf-8"));
                }
            }



        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
