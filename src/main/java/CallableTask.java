import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class CallableTask implements Callable<Integer> {

    ReentrantLock lock = new ReentrantLock() ;

    public CallableTask(int Id){
        this.id = id ;
    }
    private int id ;

    public int getId(){
        return this.id ;
    }

    public void inc(){
        this.id++ ;
    }
    public Integer call() throws Exception {
        //lock.lock();
        if(lock.tryLock()) {
            try {
                this.inc();
            } finally {
                lock.unlock();
            }
        }else{
            System.out.println("thread is waiting "+Thread.currentThread().getId());
            return call();
        }

        return this.id;

    }
}
