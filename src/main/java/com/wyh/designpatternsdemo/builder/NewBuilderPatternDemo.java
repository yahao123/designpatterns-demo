package com.wyh.designpatternsdemo.builder;

/**
 * 新式建造者模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 1:04 下午
 */
public class NewBuilderPatternDemo {

    public static void main(String[] args) {
        /**
         * 基于原始的建造者模式改良, 目前开原框架中有很多案例
         * 它是把原始的Director取消了,然后构造的步骤直接由调用者实现
         */
        ProductBuilder productBuilder = new ProductBuilder();
        Product product = productBuilder.field1("值1")
                .field2("值2")
                .field3("值3")
                .create();
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
        ProductBuilder field1(String value);
        ProductBuilder field2(String value);
        ProductBuilder field3(String value);
        Product create();
    }

    /**
     * ProductBuilder 类中中包含每个字段的构建逻辑
     */
    public static class ProductBuilder implements Builder {

        private Product product = new Product();

        @Override
        public ProductBuilder field1(String value) {
            System.out.println("创建字段1的逻辑校验等");
            product.setField1("值1");
            return this;
        }

        @Override
        public ProductBuilder field2(String value) {
            System.out.println("创建字段2的逻辑校验等");
            product.setField2("值2");
            return this;
        }

        @Override
        public ProductBuilder field3(String value) {
            System.out.println("创建字段3的逻辑校验等");
            product.setField3("值3");
            return this;
        }

        @Override
        public Product create() {
            return product;
        }
    }
}
