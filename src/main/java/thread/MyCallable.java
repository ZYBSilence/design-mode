package thread;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: zyb
 * @date: 2021/10/11 9:32
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("myCallable");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "myCallableResult";
    }
}
