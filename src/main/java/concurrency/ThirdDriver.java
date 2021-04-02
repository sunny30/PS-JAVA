package concurrency;

public class ThirdDriver {


    public static void main(String[] args) {
        ThirdCriticalSection criticalSection = new ThirdCriticalSection() ;
        Thread p = new Thread(new ProducerThread(criticalSection)) ;
        Thread c = new Thread(new ThirdConsumerThread(criticalSection)) ;

        p.start();
        c.start();
    }
}
