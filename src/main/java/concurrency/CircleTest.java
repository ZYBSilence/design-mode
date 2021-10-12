package concurrency;

import java.util.Scanner;

/**
 * @description:
 * @author: zyb
 * @date: 2020/9/27 14:52
 */
public class CircleTest {
    public static void main(String[] args) {
        final double PI = 3.14159;
        System.out.println("请输半径：");
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        double s = PI * r * r;
        double v = 4/3 * PI * r * r * r;
        System.out.println("圆的面积和球的体积分别为：");
        System.out.println("s = " + String.format("%.2f", s) +",v = " + String.format("%.2f", v));
    }
}
