package com.wyh.designpatternsdemo.mediator;

/**
 * 不使用中介者模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 2:36 下午
 */
public class WithoutMediatorPatterDemo {

    /**
     * 场景: 现在有三个模块,分别是A,B,C; A要调用B,C; B要调用A,C; C要调用A,B;
     *
     * 缺点: 模块之间相互调用,复杂度极高,很有可能牵一发而动全身
     *
     * @param args
     */
    public static void main(String[] args) {

        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }


    public static class ModuleA{

        public void execute(){
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();
            moduleB.execute("模块A");
            moduleC.execute("模块A");
        }

        public void execute(String invoker){
            System.out.println(invoker + "调用了模块A");
        }
    }

    public static class ModuleB{

        public void execute(){
            ModuleA moduleA = new ModuleA();
            ModuleC moduleC = new ModuleC();
            moduleA.execute("模块B");
            moduleC.execute("模块B");
        }

        public void execute(String invoker){
            System.out.println(invoker + "调用了模块B");
        }
    }

    public static class ModuleC{

        public void execute(){
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();

            moduleA.execute("模块C");
            moduleB.execute("模块C");
        }

        public void execute(String invoker){
            System.out.println(invoker + "调用了模块C");
        }
    }
}
