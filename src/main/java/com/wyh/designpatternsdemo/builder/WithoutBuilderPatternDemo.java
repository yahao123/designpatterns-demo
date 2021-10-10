package com.wyh.designpatternsdemo.builder;

/**
 * 没有使用建造者模式的代码
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/10 12:43 下午
 */
public class WithoutBuilderPatternDemo {

    /**
     * 弊端: 代码冗长, 可维护性差, 如果要修改一个字段的逻辑会很复杂
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建商品逻辑

        Product product = new Product();
        System.out.println("创建字段1的逻辑校验等");
        product.setField1("值1");

        System.out.println("创建字段2的逻辑校验等");
        product.setField2("值2");

        System.out.println("创建字段3的逻辑校验等");
        product.setField3("值3");

        // .....
        // 如果字段很多的话整体代码会变得很复杂, 维护者看到肯定也会很头疼
    }

    public static class Product{

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
    }
}
