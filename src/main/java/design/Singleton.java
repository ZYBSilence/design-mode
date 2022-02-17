package design;

/**
 * @description:
 * @author: zyb
 * @date: 2022/2/8 13:29
 */
public class Singleton {

    private static volatile Singleton unsingleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (unsingleton == null) {
            // 只有当第一次访问的时候才会使用synchronized关键字
            synchronized (Singleton.class) {
                if (unsingleton == null) unsingleton = new Singleton();
            }
        }
        return unsingleton;
    }
}
