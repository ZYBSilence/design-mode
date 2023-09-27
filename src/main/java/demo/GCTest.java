package demo;

/**
 * @description:
 * @author: zyb
 * @date: 2023/9/13 17:25
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[10 * 1024 * 1024];
        allocation1 = null;
    }
}
