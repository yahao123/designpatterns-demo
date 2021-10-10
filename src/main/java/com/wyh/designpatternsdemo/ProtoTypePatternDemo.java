package com.wyh.designpatternsdemo;

/**
 * 原型模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 1:26 下午
 */
public class ProtoTypePatternDemo {

    public static void main(String[] args) throws Exception {

        Product product = new Product("产品1", new Component("产品1组件"));
        Product cloneProduct = (Product) product.clone();
        System.out.println(cloneProduct);
    }

    public static class Product{

        private String name;

        private Component component;

        public Product(String name, Component component) {
            this.name = name;
            this.component = component;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            // 这是浅拷贝, 只是把值引用过去了, 实际上copyProduct中的component和当前的还是一个对象
            // return new Product(name, component);

            // 这是深拷贝, 需要递归把子对象也同时进行clone
            return new Product(name, (Component) component.clone());
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", component=" + component +
                    '}';
        }
    }

    public static class Component{

        private String name;

        public Component(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Component(name);
        }

        @Override
        public String toString() {
            return "Component{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
