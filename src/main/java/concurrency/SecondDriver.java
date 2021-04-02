package concurrency;

public class SecondDriver {

    public static void main(String[] args) {
        SecondTaskWaitAndNotify task = new SecondTaskWaitAndNotify() ;

        Thread t1 = new Thread(new SecondProduceRunnable(task)) ;
        Thread t2 = new Thread(new SecondConsumeRunnable(task)) ;


        t1.start();
        t2.start();
    }
}
