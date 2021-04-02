package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownCS implements Runnable {

    CountDownLatch countDownLatch ;
    int id ;

    CountDownCS(CountDownLatch countDownLatch,int id){
        this.countDownLatch = countDownLatch ;
        this.id = id ;
    }

    public void run() {
        try {
            Random random = new Random() ;
            if(random.nextInt()%2==1)
                Thread.sleep(1000);
            else
                Thread.sleep(2000);
            System.out.println("current id "+Thread.currentThread().getId()+" assign id is "+id);
            countDownLatch.countDown();

        }catch (Exception e){

        }
    }
}
