package com.design.mode.test01;

/**
 * @desc: 现金收费抽象类
 * @author: zyb
 * @since: 2020/7/28 15:04
 */
public abstract class CashSuper {
    /**
     * 获取收费结果的抽象类
     *
     * @param money
     * @return
     */
    public abstract double acceptCash(double money);
}
