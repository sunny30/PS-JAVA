package concurrency;

public class FourthDriver {

    public static void main(String[] args) {
        FourthCS cs = new FourthCS() ;
        Thread t1 = new Thread(new FourthProducer(cs)) ;
        Thread t2 = new Thread(new FourthConsumer(cs)) ;
        t1.start();
        t2.start();
    }
}
