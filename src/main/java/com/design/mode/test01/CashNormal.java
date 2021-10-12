package com.design.mode.test01;

/**
 * @desc: 正常收费子类
 * @author: zyb
 * @since: 2020/7/28 15:08
 */
public class CashNormal extends CashSuper {

    /**
     * 正常收费方法
     *
     * @param money
     * @return
     */
    @Override
    public double acceptCash(double money) {
        return money;
    }

    public double get(double money){
        return money+1d;
    }
}
