package com.wyh.designpatternsdemo.factory;

/**
 * 抽象工厂模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/7 5:18 下午
 */
public class AbstractFactoryMethod {

    public interface Product {
        // 创建商品
        void creatProduct();
    }

    public interface ProductA extends Product {

    }

    public static class ProductA1 implements ProductA {
        @Override
        public void creatProduct() {
            System.out.println("创建商品A1");
        }
    }

    public static class ProductA2 implements ProductA {
        @Override
        public void creatProduct() {
            System.out.println("创建商品A2");
        }
    }

    public static class ProductA3 implements ProductA {
        @Override
        public void creatProduct() {
            System.out.println("创建商品A3");
        }
    }

    public interface ProductB extends Product {
    }

    public static class ProductB1 implements ProductB {
        @Override
        public void creatProduct() {
            System.out.println("创建商品B1");
        }
    }

    public static class ProductB2 implements ProductB {
        @Override
        public void creatProduct() {
            System.out.println("创建商品B2");
        }
    }

    public static class ProductB3 implements ProductB {
        @Override
        public void creatProduct() {
            System.out.println("创建商品B3");
        }
    }

    public interface ProductFactory {
        ProductA createProductA();

        ProductB createProductB();
    }

    public static class ProductFactory1 implements ProductFactory {

        public static ProductFactory1 instance = new ProductFactory1();

        public static ProductFactory1 getInstance() {
            return instance;
        }

        @Override
        public ProductA createProductA() {
            return new ProductA1();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB1();
        }
    }


    public static class ProductFactory2 implements ProductFactory {

        public static ProductFactory2 instance = new ProductFactory2();

        public static ProductFactory2 getInstance() {
            return instance;
        }

        @Override
        public ProductA createProductA() {
            return new ProductA2();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB2();
        }
    }


    public static class ProductFactory3 implements ProductFactory {
        public static ProductFactory3 instance = new ProductFactory3();

        public static ProductFactory3 getInstance() {
            return instance;
        }

        @Override
        public ProductA createProductA() {
            return new ProductA3();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB3();
        }
    }

    public static void main(String[] args) {
        // 如果不使用抽象工厂的话代码是这么写的
        // 创建 A1 + B1的组合商品
//        ProductA1 productA1 = new ProductA1();
//        ProductB1 productB1 = new ProductB1();
//        productA1.creatProduct();
//        productB1.creatProduct();
//        // 创建 A2 + B2的组合商品
//        ProductA2 productA2 = new ProductA2();
//        ProductB2 productB2 = new ProductB2();
//        productA2.creatProduct();
//        productB2.creatProduct();
//        // 创建A3 + B3的组合商品
//        ProductA3 productA3 = new ProductA3();
//        ProductB3 productB3 = new ProductB3();
//        productA3.creatProduct();
//        productB3.creatProduct();


        /**
         * 上述模式的弊端, 由于商品是组合生产,如果其中一个组合要更改规则,那么可能全部代码都要进行改动
         *
         * 抽象工厂核心: 将每一种商品组合当做一个工厂, 如果要更改组合那么去更改工厂类中的实现,
         * 假如: 如果要更改A1+B1的组合商品为 A1+B2, 那么直接去修改ProductFactory1.createProductB()这个方法即可
         */
        // 使用抽象工厂的代码:
        // 创建A1+B1组合商品
        ProductA productA = ProductFactory1.getInstance().createProductA();
        ProductB productB = ProductFactory1.getInstance().createProductB();
        productA.creatProduct();
        productB.creatProduct();
        // 创建 A2 + B2组合商品
        ProductA factoryProductA2 = ProductFactory2.getInstance().createProductA();
        ProductB factoryProductB2 = ProductFactory2.getInstance().createProductB();
        factoryProductA2.creatProduct();
        factoryProductB2.creatProduct();
        // 创建A3+B3组合商品
        ProductA factoryProductA3 = ProductFactory3.getInstance().createProductA();
        ProductB factoryProductB3 = ProductFactory3.getInstance().createProductB();
        factoryProductA3.creatProduct();
        factoryProductB3.creatProduct();
    }
}
