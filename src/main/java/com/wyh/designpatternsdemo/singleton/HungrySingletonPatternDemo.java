package com.wyh.designpatternsdemo.singleton;

/**
 *
 * 单例模式- 饿汉模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 6:38 下午
 */
public class HungrySingletonPatternDemo {

    public static void main(String[] args) {
        // HungrySingletonObject只有一个实例
        HungrySingletonObject.getInstance().execute();
    }

}
