package cn.mylava._300._8_GOF._15_Strategy.amount2;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/03/2018
 */
public class StrategyFactory {
    private static final String PACKAGE_PATH=StrategyFactory.class.getResource("").getPath();
    private ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    //存储所有策略
    private List<Class<? extends Strategy>> strategyList;


    /**
     * 根据客户的总金额产生相应的策略
     * @param amount
     * @return
     */
    public Strategy createStrategy(double amount){
        //在策略列表查找策略
        for (Class<? extends Strategy> clazz : strategyList) {
            AmountRegion regin = handleAnnotation(clazz);//获取该策略的注解
            //判断金额是否在注解的区间
            if (amount > regin.lowerBound() && amount <= regin.upperBound()) {
                try {
                    //是的话返回一个当前策略的实例
                    return clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("策略获得失败");
                }
            }
        }
        throw new RuntimeException("策略获得失败");
    }

    /**
     * 处理注解，传入一个策略类，返回它的注解
     * @param clazz
     * @return
     */
    private AmountRegion handleAnnotation(Class<? extends Strategy> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof AmountRegion) {
                return (AmountRegion) annotations[i];
            }
        }
        return null;
    }


    //在工厂初始化时要初始化策略列表
    private void init(){
        strategyList = new ArrayList<Class<? extends Strategy>>();
        //获取到包下所有的class文件
        File[] resources = getResources();
        Class<Strategy> strategyClass = null;
        try {
            strategyClass = (Class<Strategy>) classloader.loadClass(Strategy.class.getName());//使用相同的加载器加载策略接口
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("未找到策略接口");
        }
        for (int i = 0; i < resources.length; i++) {
            try {
                //载入包下的类
                Class<?> clazz = classloader.loadClass(StrategyFactory.class.getPackage().getName() + "."+resources[i].getName().replace(".class", ""));
                //判断是否是Strategy的实现类并且不是Strategy它本身，满足的话加入到策略列表
                if (Strategy.class.isAssignableFrom(clazz) && clazz != strategyClass) {
                    strategyList.add((Class<? extends Strategy>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //获取扫描的包下面所有的class文件
    private File[] getResources(){
//        String path = classloader.getResource(PACKAGE_PATH).getPath();
//        System.out.println(path);
        File file = new File(PACKAGE_PATH);
        return file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".class")) {//只扫描class文件
                    return true;
                }
                return false;
            }
        });
    }

    //静态内部类实现单例模式
    public StrategyFactory() {
        init();
    }
    public static StrategyFactory getInstance(){
        return StrategyFactoryInstance.instance;
    }

    private static class StrategyFactoryInstance{
        private static StrategyFactory instance = new StrategyFactory();
    }

}
