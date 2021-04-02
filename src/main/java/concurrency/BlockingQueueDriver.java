package concurrency;

public class BlockingQueueDriver {

    public static void main(String[] args) {
        BlockingQueueCS cs = new BlockingQueueCS() ;
        new Thread(new BlockingQueueProducerThread(cs)).start();
        new Thread(new BlockingQueueConsumerThread(cs)).start();
    }
}
