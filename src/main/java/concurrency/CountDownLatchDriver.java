package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDriver {

    public static void main(String[] args) {
        try {
            CountDownLatch latch = new CountDownLatch(4);
            ExecutorService service = Executors.newFixedThreadPool(4);
            //CountDownCS cs = new CountDownCS(latch);

            for (int i = 0; i < 4; i++)
                service.submit(new CountDownCS(latch,i));
            latch.await();
            service.shutdown();
        }catch (Exception e){

        }
    }
}
