package com.design.mode.test01;

/**
 * @desc: 收费算法类
 * @author: zyb
 * @since: 2020/7/28 15:36
 */
class CashContext {

    CashSuper cs = null;

    CashContext(String type) {
        if ("正常收费".equals(type)) {
            cs = new CashNormal();
        } else if ("打八折".equals(type)) {
            cs = new CashRebate(0.8d);
        } else if ("满300减100".equals(type)) {
            cs = new CashReturn(300d, 100d);
        }
    }


    double getResult(double money) {
        return cs.acceptCash(money);
    }
}
