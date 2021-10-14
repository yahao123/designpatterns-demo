package com.wyh.designpatternsdemo.strategy;

import java.math.BigDecimal;

/**
 * 策略模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/14 11:56 上午
 */
public class StrategyPatternDemo {

    /**
     * 之前的ifelse全部都维护到了DiscountStratgy中, 然后每种策略都实现 DiscountStrategy接口
     * @param args
     */
    public static void main(String[] args) {
        // DiscountStrategy discountStrategy = StrategyFactory.getDiscountStrategy(1);
        DiscountStrategy discountStrategy = StrategyFactory.getDiscountStrategy(2);
        discountStrategy.calculateDiscountAmount();

    }


    public interface DiscountStrategy{
        BigDecimal calculateDiscountAmount();
    }

    public static class RateDiscountStrategy implements DiscountStrategy{
        @Override
        public BigDecimal calculateDiscountAmount() {
            System.out.println("百分比优惠计算策略");
            return null;
        }
    }

    public static class FullReductionDiscountStrategy implements DiscountStrategy{
        @Override
        public BigDecimal calculateDiscountAmount() {
            System.out.println("满减优惠计算策略");
            return null;
        }
    }


    public static class StrategyFactory{

        public static DiscountStrategy getDiscountStrategy(Integer discountType){
            if (discountType.equals(1)){
                return new RateDiscountStrategy();
            }else if (discountType.equals(2)){
                return new FullReductionDiscountStrategy();
            }
            // ... 其他类型
            return null;
        }
    }
}
