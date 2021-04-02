package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstDriver {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2) ;
        service.submit(new FirstTask(1,2)) ;
        service.submit(new FirstTask(2,-1)) ;
        service.shutdown();
    }

}
