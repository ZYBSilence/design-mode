package design.decorator;

/**
 * @description:
 * @author: zyb
 * @date: 2022/5/23 15:24
 */
public class Client {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }

}
