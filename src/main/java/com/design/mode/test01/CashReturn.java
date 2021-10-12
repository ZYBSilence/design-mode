package com.design.mode.test01;

/**
 * @desc: 返利收费子类
 * @author: zyb
 * @since: 2020/7/28 15:20
 */
public class CashReturn extends CashSuper {

    /**
     * 返利条件
     */
    private double moneyCondition;
    /**
     * 返利值
     */
    private double moneyReturn;

    CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    /**
     * 返利收费方法
     *
     * @param money
     * @return
     */
    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition){
            result = money - (money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
