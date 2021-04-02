package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FifthDriver {

    public static void main(String[] args) {
        FifthCS cs = new FifthCS();
        ExecutorService executorService = Executors.newFixedThreadPool(20) ;
        for(int i=0;i<20;i++){
            executorService.submit(new FifthProducer(cs)) ;
        }
        executorService.shutdown();
    }
}
