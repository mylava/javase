package cn.mylava._300._5_Socket._195_httpserver._7_reflect.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * comment: SAX解析xml具体实现类
 *
 * @author: lipengfei
 * @date: 02/01/2018
 */
public class WebappHanlder extends DefaultHandler {

    private List<Entity> entityList;
    private List<Mapping> mappingList;
    private Entity entity;
    private Mapping mapping;
    private String tag;
    private boolean isMap;

    @Override
    public void startDocument() throws SAXException {
        //文档解析开始
        entityList = new ArrayList<>();
        mappingList = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        //解析文档结束
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //元素开始
        if (null!=qName) {
            tag = qName;
            if (qName.equals("servlet")) {
                isMap = false;
                entity = new Entity();
            } else if (qName.equals("servlet-mapping")) {
                isMap = true;
                mapping = new Mapping();
            }

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //结束元素
        if (null!=qName) {
            if (qName.equals("servlet")) {
                entityList.add(entity);
            } else if (qName.equals("servlet-mapping")) {
                mappingList.add(mapping);
            }
        }
        tag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //处理内容
        if (null!=tag) {
            String str = new String(ch,start,length);
            if (isMap) {
                if (tag.equals("servlet-name")) {
                    mapping.setName(str);
                } else if (tag.equals("url-pattern")) {
                    mapping.getUrlPatterns().add(str);
                }
            } else {
                if (tag.equals("servlet-name")) {
                    entity.setName(str);
                } else if (tag.equals("servlet-class")) {
                    entity.setClazz(str);
                }
            }
        }
    }


    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<Mapping> mappingList) {
        this.mappingList = mappingList;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        WebappHanlder hanlder = new WebappHanlder();
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/mylava/_300/_5_Socket/_195_httpserver/_7_reflect/web.xml"),hanlder);
        for (Entity entity : hanlder.getEntityList()) {
            System.out.println(entity);
        }
    }
}
