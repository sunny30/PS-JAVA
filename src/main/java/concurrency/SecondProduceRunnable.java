package concurrency;

public class SecondProduceRunnable implements  Runnable{
    SecondTaskWaitAndNotify task ;

    SecondProduceRunnable(SecondTaskWaitAndNotify task){
        this.task = task ;
    }
    public void run(){
        try {
            task.produce();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
