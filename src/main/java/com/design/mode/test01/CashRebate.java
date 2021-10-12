package com.design.mode.test01;

/**
 * @desc: 打折收费子类
 * @author: zyb
 * @since: 2020/7/28 15:10
 */
public class CashRebate extends CashSuper {

    private double moneyRebate = 1d;

    /**
     * 实例化时候输入折扣率
     *
     * @param moneyRebate
     */
    CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    /**
     * 打折收费方法
     *
     * @param money
     * @return
     */
    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
