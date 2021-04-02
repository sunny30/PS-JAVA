package concurrency;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerThread implements Runnable{

    BlockingQueueCS cs ;

    BlockingQueueProducerThread(BlockingQueueCS cs){
        this.cs =cs ;
    }

    public void run(){
        while (true){
            try {
                cs.produce();
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
