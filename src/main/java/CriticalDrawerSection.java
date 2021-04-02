import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalDrawerSection implements Runnable {

    static int val=10 ;
    int addval ;


    int subval ;
    boolean deposit = false ;
    boolean withdraw = false ;
//    CriticalDrawerSection(int val){
//        this.val =val ;
//    }
    private  ReentrantLock lock = new ReentrantLock() ;
    private  Condition condition = lock.newCondition() ;

    public void run()  {
        if(lock.tryLock()) {
            try {
               if(subval < 0 && -subval > val) {
                    condition.await();
                    addval =subval ;
                }
                val += addval;
                condition.signalAll();
            }catch (Exception e){
                System.out.println(e.toString());
            } finally{
                lock.unlock();
            }
        }else{
            run();
        }

    }


    public void setAddval(int addval) {
        this.addval = addval;
    }






}
