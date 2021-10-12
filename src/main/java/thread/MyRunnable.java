package thread;

/**
 * @description:
 * @author: zyb
 * @date: 2021/10/11 9:29
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myRunnable");
    }
}
