package demo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @description:
 * @author: zyb
 * @date: 2023/7/25 14:06
 */
public class SyncLock {

    private final Sync sync;

    public SyncLock() {
        sync = new Sync();
    }

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        // 该线程是否正在独占资源，只有用到 Condition 才需要去实现
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

}
