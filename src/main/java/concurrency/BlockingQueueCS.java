package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCS {
    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    static  int counter ;
    public void produce() {
       //    int counter = 0;

        try {
            System.out.println("putting counter "+counter);
            queue.put(String.valueOf(counter));
            ++counter;
            //Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void consume() {
        try {
            String head = queue.take();
            System.out.println("consume of head is " + head);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
