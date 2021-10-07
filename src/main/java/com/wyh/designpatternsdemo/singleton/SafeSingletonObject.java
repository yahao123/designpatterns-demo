package com.wyh.designpatternsdemo.singleton;

/**
 * 单例模式-饱汉模式-线程安全(但是并不是绝对的线程安全)
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 6:49 下午
 */
public class SafeSingletonObject {

    private SafeSingletonObject(){}

    private static SafeSingletonObject instance;

    public static SafeSingletonObject getInstance() {
        if (instance == null){
            synchronized (SafeSingletonObject.class){
                // 双重校验, 这里防止第一个线程已经创建完对象后,第二个线程获得锁再次创建
                // 如果第二个线程来到这里证明第一个线程已经把这个对象创建好了,所以要在这里把第二个对象拦在外面
                if (instance == null){
                    instance = new SafeSingletonObject();
                }
            }
        }
        return instance;
    }

    public void execute(){

    }
}
