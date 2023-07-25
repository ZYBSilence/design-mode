package demo;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description:
 * @author: zyb
 * @date: 2023/7/25 10:15
 */
public class TicketLock implements Lock {

    private AtomicInteger serviceCount = new AtomicInteger(0);
    private AtomicInteger ticketCount = new AtomicInteger(0);
    private final ThreadLocal<Integer> owner = new ThreadLocal<>();

    @Override
    public void lock() {
        owner.set(ticketCount.getAndIncrement());
        while (serviceCount.get() != owner.get());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        serviceCount.compareAndSet(owner.get(), owner.get() + 1);
        owner.remove();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
