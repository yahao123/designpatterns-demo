package com.wyh.designpatternsdemo.mediator;

/**
 * 中介模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 2:35 下午
 */
public class MediatorPatternDemo {


    public static void main(String[] args) {

        /**
         * 好处: 各个模块都不知道对方的存在, 只需要知道一个中介即可
         */

        Mediator mediator = new Mediator();

        ModuleA moduleA = new ModuleA(mediator);
        ModuleB moduleB = new ModuleB(mediator);
        ModuleC moduleC = new ModuleC(mediator);

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }

    public static class Mediator {
        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;


        public void invokeModuleA() {
            moduleB.execute("模块A");
            moduleC.execute("模块A");
        }

        public void invokeModuleB() {
            moduleA.execute("模块B");
            moduleC.execute("模块B");
        }

        public void invokeModuleC() {
            moduleB.execute("模块C");
            moduleA.execute("模块C");
        }


        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }
    }


    public static class ModuleA {

        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleA(this);
        }

        public void execute() {
            mediator.invokeModuleA();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用了模块A");
        }
    }

    public static class ModuleB {

        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleB(this);
        }

        public void execute() {
            mediator.invokeModuleB();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用了模块B");
        }
    }

    public static class ModuleC {
        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleC(this);
        }

        public void execute() {
            mediator.invokeModuleC();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用了模块C");
        }
    }

}
