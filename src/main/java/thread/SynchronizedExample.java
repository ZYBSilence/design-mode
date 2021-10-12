package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: zyb
 * @date: 2021/10/11 14:05
 */
public class SynchronizedExample {
    public void func1() {
        System.out.println(111);
        synchronized (this) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(222);
    }


    public synchronized void func () {
        System.out.println("123");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(456);
    }

    public void funcClass() {
        synchronized (SynchronizedExample.class) {
            System.out.println("123");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(456);
        }
    }


    public synchronized static void fun() {
        System.out.println("123");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(456);
    }


    public static void main(String[] args) {
//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
//        executorService.shutdown();


//        SynchronizedExample e1 = new SynchronizedExample();
//        SynchronizedExample e2 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e2.func1());
//        executorService.shutdown();

//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func());
//        executorService.execute(() -> e1.func());
//        executorService.shutdown();

//        SynchronizedExample e1 = new SynchronizedExample();
//        SynchronizedExample e2 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.funcClass());
//        executorService.execute(() -> e2.funcClass());
//        executorService.shutdown();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> SynchronizedExample.fun());
        executorService.execute(() -> SynchronizedExample.fun());
        executorService.shutdown();
    }
}
