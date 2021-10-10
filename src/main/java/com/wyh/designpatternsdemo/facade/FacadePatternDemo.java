package com.wyh.designpatternsdemo.facade;

/**
 * 使用门面/外观模式的代码
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 12:08 下午
 */
public class FacadePatternDemo {

    /**
     * 这样把子系统1的实现封装到一起,对完只暴露出一个门面,这样的话系统2的代码也比较简洁,
     * 如果子系统1的实现需要改动也只需要改动一个地方即可
     *
     * @param args
     */
    public static void main(String[] args) {
        FacadePatternDemo.systemMode();
    }

    public static void systemMode() {
        ModelA modelA = new ModelA();
        ModelB modelB = new ModelB();
        ModelC modelC = new ModelC();

        modelA.execute();
        modelB.execute();
        modelC.execute();
    }


    public static class ModelA {
        public void execute() {
            System.out.println("子系统1的A模块");
        }
    }


    public static class ModelB {
        public void execute() {
            System.out.println("子系统1的B模块");
        }
    }

    public static class ModelC {
        public void execute() {
            System.out.println("子系统1的C模块");
        }
    }
}
