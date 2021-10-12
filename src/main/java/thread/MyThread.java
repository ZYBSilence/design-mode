package thread;

/**
 * @description:
 * @author: zyb
 * @date: 2021/10/11 9:41
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("myThread");
        super.run();
    }
}
