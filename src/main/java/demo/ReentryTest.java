package demo;

/**
 * @description: synchronized 是可重入性测试
 * @author: zyb
 * @date: 2023/7/24 15:36
 */
public class ReentryTest extends A{

    public static void main(String[] args) {
        ReentryTest reentry = new ReentryTest();
        reentry.doA();
    }

    @Override
    public synchronized void doA() {
        System.out.println("子类方法：ReentryTest.doA() ThreadId：" + Thread.currentThread().getId());
        doB();
    }

    private synchronized void doB() {
        super.doA();
        System.out.println("子类方法：ReentryTest.doB() ThreadId：" + Thread.currentThread().getId());
    }

}


class A {
    public synchronized void doA() {
        System.out.println("父类方法：A.doA() ThreadId：" + Thread.currentThread().getId());
    }
}
