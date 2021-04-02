package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FourthCS {

    Lock lock = new ReentrantLock() ;
    Condition condition = lock.newCondition() ;


    public void produce(){
        try{
           lock.lock();
            System.out.println("Producing messages");
            condition.await();

        }catch (Exception e){

        } finally{
            lock.unlock();
        }
    }

    public void consume(){
        try{
            lock.lock();
            System.out.println("Consuming messages");
            condition.signalAll();

        }catch (Exception e){

        } finally{
            lock.unlock();
        }
    }
}
