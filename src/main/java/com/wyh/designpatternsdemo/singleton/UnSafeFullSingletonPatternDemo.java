package com.wyh.designpatternsdemo.singleton;

/**
 * 单例模式- 饱汉式 - 线程不安全
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 6:46 下午
 */
public class UnSafeFullSingletonPatternDemo {

    public static void main(String[] args) {
        // 线程不安全的单例模式
        UnSafeFullSingletonObject.getInstance().execute();
    }

}
