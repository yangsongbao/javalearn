package per.yang.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<Integer>();

    public void lock(){
        int myTicket = ticketNum.getAndIncrement();
        LOCAL.set(myTicket);
        while (myTicket != serviceNum.get()){

        }
    }

    public void unlock(){
        Integer myTicket = LOCAL.get();
        serviceNum.compareAndSet(myTicket, myTicket + 1);
    }
}
