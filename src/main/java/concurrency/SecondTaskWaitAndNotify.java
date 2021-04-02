package concurrency;

public class SecondTaskWaitAndNotify {



    public void produce() throws Exception{
        synchronized (this){
            System.out.println("Producing message..");
            wait();
            System.out.println("After wait call");

        }
    }

    public void consume() throws Exception{
        synchronized (this){
            System.out.println("Consuming message..");
            notify();
            //System.out.println("After wait call");

        }


    }
}
