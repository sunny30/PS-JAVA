package concurrency;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Runnable{

    CyclicBarrier barrier ;
    int id ;
    CyclicBarrierThread(CyclicBarrier barrier,int id){
        this.id = id ;
        this.barrier = barrier ;
    }

    public void run(){
        try {
            Random random = new Random();
            if (random.nextInt() % 2 == 1) {
                Thread.sleep(2000);
            }else{
                Thread.sleep(1000);
            }
            System.out.println("id is "+id);
            barrier.await() ;
            System.out.println(id+" is finished");
        }catch (Exception e){

        }

    }
}
