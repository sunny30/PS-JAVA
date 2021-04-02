package critical;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalCounterSection {

    private ReentrantLock lock = new ReentrantLock();
    private Condition depositCondition = lock.newCondition();
    private Condition withDrawCondition = lock.newCondition();


    int val;
    CriticalCounterSection(int val) {
        this.val = val ;
    }

    public void depositMoney(int add){
        try {
            lock.lock();
            this.val += add;
            this.withDrawCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void withDrawMoney(int sub){
        try {
            lock.lock();
            while(sub > val)
                this.withDrawCondition.await();
           // else {
                this.val-=sub ;
                this.depositCondition.signalAll();
            //}
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            lock.unlock();
        }
    }

    public int getVal() {
        return this.val;
    }


}
