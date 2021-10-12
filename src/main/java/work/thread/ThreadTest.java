package work.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zyb
 * @date: 2020/12/8 14:31
 */
@Component
public class ThreadTest {
    @Async
    public void threadTest01() {
        try {
            Thread.sleep(5000L);
            System.out.println("test01");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void threadTest02() {
        System.out.println("test02");
    }
}
