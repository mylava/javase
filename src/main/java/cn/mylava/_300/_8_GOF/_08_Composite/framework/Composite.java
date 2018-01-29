package cn.mylava._300._8_GOF._08_Composite.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * comment: 容器组件
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public interface Composite extends Component{
    List<Leaf> list = new ArrayList<>();
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
    void operation();
}
