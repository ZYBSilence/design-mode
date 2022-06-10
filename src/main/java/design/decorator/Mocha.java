package design.decorator;

/**
 * @description:
 * @author: zyb
 * @date: 2022/5/23 15:22
 */
public class Mocha extends CondimentDecorator{
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost() + 1;
    }
}
