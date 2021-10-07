package com.wyh.designpatternsdemo.singleton;

/**
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 6:50 下午
 */
public class SafeSingletonPatternDemo {

    public static void main(String[] args) {
        // 线程安全的单例模式-饱汉模式
        SafeSingletonObject.getInstance().execute();
    }
}
