package concurrency;

public class ProducerThread implements Runnable{

    ThirdCriticalSection criticalSection ;
    ProducerThread(ThirdCriticalSection criticalSection){
        this.criticalSection = criticalSection ;
    }

    public void run(){
        for(int i=0;i<10;i++)
        criticalSection.produce(i);
    }
}
