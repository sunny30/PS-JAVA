package concurrency;

public class BlockingQueueConsumerThread implements Runnable {

    BlockingQueueCS cs ;
    BlockingQueueConsumerThread(BlockingQueueCS cs){
        this.cs = cs ;
    }

    public void run(){
        while(true){
            try {
                cs.consume();
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
