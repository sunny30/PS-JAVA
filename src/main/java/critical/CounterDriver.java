package critical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterDriver {

    public static void main(String[] args) {
        CriticalCounterSection section = new CriticalCounterSection(10) ;

        Runnable run1 = new ProducerThread(section,2) ;
        Thread thread1 = new Thread(run1) ;
        Runnable run2 = new ProducerThread(section,4) ;
        Thread thread2 = new Thread(run2) ;
        Runnable run3 = new ConsumerThread(section,12) ;
        Thread thread3 = new Thread(run3) ;
        Runnable run4 = new ConsumerThread(section,2) ;
        Thread thread4 = new Thread(run4) ;

        ExecutorService executorService = Executors.newFixedThreadPool(2) ;

        executorService.execute(thread3);
        System.out.println(section.val);

        executorService.execute(thread1);
        System.out.println(section.val);

        executorService.execute(thread2);
        executorService.execute(thread4);
        executorService.shutdown();
        System.out.println(section.getVal());


    }
}
