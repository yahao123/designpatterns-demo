package com.wyh.designpatternsdemo.singleton;

/**
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 6:47 下午
 */
public class UnSafeFullSingletonObject {

    private UnSafeFullSingletonObject(){}

    private static UnSafeFullSingletonObject instance;

    /**
     * 这里不是线程安全的,如果有多线程获取这个实例的话可能会导致这个类创建多次
     * @return
     */
    public static UnSafeFullSingletonObject getInstance() {
        if (instance == null){
            instance = new UnSafeFullSingletonObject();
        }
        return instance;
    }

    public void execute(){

    }
}
