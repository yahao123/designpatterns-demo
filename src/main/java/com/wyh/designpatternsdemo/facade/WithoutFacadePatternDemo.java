package com.wyh.designpatternsdemo.facade;

/**
 * 不使用门面/外观模式的代码
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 12:08 下午
 */
public class WithoutFacadePatternDemo {

    /**
     * 假如这个方法是业务2的内部方法,可以看到在子系统2中如果想要用子系统1的流程必须要
     * 把子系统1的代码从别的地方粘贴过来, 如果其他子系统也想使用呢那就得都粘贴一遍,如果要是
     * 子系统1的代码有改动,那需要改动的地方就太多了,而且很容易改错.
     * @param args
     */
    public static void main(String[] args) {
        // 现在子系统2要使用子系统1内部的流程
        ModelA modelA = new ModelA();
        ModelB modelB = new ModelB();
        ModelC modelC = new ModelC();

        modelA.execute();
        modelB.execute();
        modelC.execute();
    }


    public static class ModelA{
        public void execute(){
            System.out.println("子系统1的A模块");
        }
    }


    public static class ModelB{
        public void execute(){
            System.out.println("子系统1的B模块");
        }
    }

    public static class ModelC{
        public void execute(){
            System.out.println("子系统1的C模块");
        }
    }
}
