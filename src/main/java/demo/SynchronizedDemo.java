package demo;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;


/**
 * @description:
 * @author: zyb
 * @date: 2023/7/24 15:02
 */
public class SynchronizedDemo {
    private static volatile int counter = 0;

//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                for (int i1 = 0; i1 < 10000; i1++) {
//                    add();
//                }
//            });
//            thread.start();
//        }
//        // 等10个线程运行完毕
//        Thread.sleep(1000);
//        System.out.println(counter);
//    }
//
//    public static void add() {
////        counter++;
//
//        synchronized (SynchronizedDemo.class) {
//            counter++;
//        }
//    }

    public static boolean sign = false;
    public static void main(String[] args) {
        Thread Thread01 = new Thread(() -> {
            int i = 0;
            while (!sign) {
                i++;
                add(i);
            }
        });
        Thread Thread02 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {
            }
            sign = true;
            System.out.println("vt.sign = true  while (!sign)");
        });
        Thread01.start();
        Thread02.start();
    }

    public static synchronized int add(int i) {
        return i + 1;
    }
}
