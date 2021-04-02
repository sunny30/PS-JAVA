package concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDriver {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5,new BarrierThread()) ;
        ExecutorService service =  Executors.newFixedThreadPool(5) ;
        for(int i =0 ; i<5;i++){
            service.submit(new CyclicBarrierThread(barrier,i+1)) ;
        }

        service.shutdown();
    }
}
