package thread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author jinyf
 * @date 2021/7/21 22:52
 */
public class Test {
    public static void setAge(Integer age ,Object object) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = object.getClass().getDeclaredMethod("setAge",Integer.class);
        method.invoke(object,age);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ExecutionException, InterruptedException {
//        Teacher teacher = new Teacher();
//        setAge(2,teacher);
//        System.out.println(teacher.getAge());

//        MyCallable myCallable = new MyCallable();
//        FutureTask futureTask = new FutureTask<>(myCallable);
//        Thread thread1 = new Thread(futureTask);
//        thread1.start();
//        System.out.println(futureTask.get());
//
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//        thread.start();
//
//        MyThread myThread = new MyThread();
//        myThread.start();

//        testExecutor();

//        CompletableFuture.runAsync(Test::testRunAsync);
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(Test::testSupplyAsync);
//        System.out.println(future);
//        System.out.println(future.get());
//        Thread.sleep(3000);

//        Thread thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("Main run");

//        Thread thread2 = new MyThread2();
//        thread2.start();
//        thread2.interrupt();
    }

    private static void testExecutor(){
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }

    private static void testRunAsync(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testRunAsync");
    }

    private static String testSupplyAsync(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testSupplyAsync";
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                System.out.println("interrupted");
            }
            System.out.println("Thread end");
        }
    }
}
