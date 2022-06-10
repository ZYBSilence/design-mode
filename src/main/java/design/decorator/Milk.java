package design.decorator;

import org.springframework.cache.interceptor.CacheInterceptor;

/**
 * @description:
 * @author: zyb
 * @date: 2022/5/23 15:21
 */
public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost() + 1;
    }
}
