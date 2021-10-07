package com.wyh.designpatternsdemo.singleton;

/**
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 6:39 下午
 */
public class HungrySingletonObject {

    private HungrySingletonObject(){
    }
    // 在类初始化的时候就会生成一个实例对象, 后期只需要调用 getInstance方法来获取这个对象即可
    private static HungrySingletonObject instance = new HungrySingletonObject();

    public static HungrySingletonObject getInstance() {
        return instance;
    }

    public void execute(){

    }
}
