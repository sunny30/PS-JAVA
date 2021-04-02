package concurrency;

public class ThirdConsumerThread implements  Runnable{

    ThirdCriticalSection criticalSection ;

    ThirdConsumerThread(ThirdCriticalSection criticalSection){
        this.criticalSection = criticalSection ;
    }

    public void run(){
        while (true){
            criticalSection.consume();
        }
    }
}
