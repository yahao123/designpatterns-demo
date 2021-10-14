package com.wyh.designpatternsdemo.strategy;

import java.math.BigDecimal;

/**
 * 不使用 策略模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/14 11:50 上午
 */
public class WithoutStrategyPatternDemo {

    /**
     * 缺点: 大量的if/else 导致代码荣誉,后期维护人员很头疼
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer discountType = 1;
        // 计算优惠金额
        if (discountType.equals(1)){
            // 优惠逻辑
            System.out.println("优惠方式1");
        }else if (discountType.equals(2)){
            // 优惠逻辑
            System.out.println("优惠方式2");
        }else if (discountType.equals(3)){
            // 优惠逻辑
            System.out.println("优惠方式3");
        }
        // ....
    }
}
