package cn.mylava.Tmp;

import groovy.lang.*;
import org.codehaus.groovy.runtime.InvokerHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lipengfei
 */
public class GroovyTest {

    private static Map<String, Object> scriptCache = new ConcurrentHashMap<String, Object>();

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        final GroovyTest groovyTest = new GroovyTest();

//        groovyTest.runShell();
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        groovyTest.runShell();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }

                }

            }).start();
        }
    }

    public boolean isCached(String cacheKey) {
        return scriptCache.containsKey(cacheKey);
    }


    public void runShell() throws IllegalAccessException, InstantiationException {
        Object scriptObject = null;
        Binding binding = new Binding();
        Script shell = null;

        StringBuilder script = new StringBuilder();
        Class groovyClass = null;
        String cacheKey = "mystrategy";
        script.append("import cn.mylava.Tmp.test.SignConf;")
                .append("import cn.mylava.Tmp.TestSign;")
                .append("public String test(Object[] param) {\n")
                .append("for (String a : (List<String>)param[2]) {\n")
                .append("System.out.println(a);")
                .append("}\n")
                .append("SignConf conf = new SignConf();")
                .append("conf.setSecrect(param[0]);")
                .append("conf.setParams(\"xx=yy&aa=bb\");")
                .append("conf.setEncryp(param[1]);")
                .append("conf.setCaseStr(\"UPPER\");")
                .append("conf.setSort(\"DESC\");")
                .append("String expression = \"(A+(B*C)*D+A)*E\";")
                .append("String result = TestSign.evaluateExpression(expression,conf);")
                .append("return result;")
                .append("}");
        List<String> testList = new ArrayList<>();
        testList.add("1");
        testList.add("2");
        testList.add("3");

        Object[] param = {"A","SHA1",testList};

        if (isCached(cacheKey)) {
            System.out.println("yes---");
            groovyClass = (Class) scriptCache.get(cacheKey);
        } else {
            synchronized (this.getClass()) {
                System.out.print("no>>>>");
                System.out.println(scriptCache.keySet().isEmpty());
                GroovyClassLoader groovyLoader = new GroovyClassLoader();
                groovyClass = groovyLoader.parseClass(script.toString());
                if (!isCached(cacheKey)) {
                    scriptCache.put(cacheKey, groovyClass);
                }
            }
        }
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        String result = (String) groovyObject.invokeMethod("test",param);


        System.out.println(result);
    }
}
