package com.wyh.designpatternsdemo.builder;

/**
 * 构建者模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 12:52 下午
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        Product product = Director.builder("值1", "值2", "值3");
        System.out.println(product);
    }

    public static class Product {
        private String field1;

        private String field2;

        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    ", field3='" + field3 + '\'' +
                    '}';
        }
    }

    public interface Builder{
        void field1(String value);
        void field2(String value);
        void field3(String value);
        Product create();
    }

    /**
     * ProductBuilder 类中中包含每个字段的构建逻辑
     */
    public static class ProductBuilder implements Builder{

        private Product product = new Product();

        @Override
        public void field1(String value) {
            System.out.println("创建字段1的逻辑校验等");
            product.setField1("值1");
        }

        @Override
        public void field2(String value) {
            System.out.println("创建字段2的逻辑校验等");
            product.setField2("值2");
        }

        @Override
        public void field3(String value) {
            System.out.println("创建字段3的逻辑校验等");
            product.setField3("值3");
        }

        @Override
        public Product create() {
            return product;
        }
    }

    /**
     * Director 类是一个指导类, 它负责Product的创建步骤
     * 它并不需要关心你每个字段的逻辑, 只关心你的构建流程或步骤
     */
    public static class Director{

        public static Product builder(String field1, String field2, String field3){
            ProductBuilder productBuilder = new ProductBuilder();
            productBuilder.field1(field1);
            productBuilder.field2(field2);
            productBuilder.field3(field3);
            return productBuilder.create();
        }
    }
}
