package concurrency;

public class SecondConsumeRunnable implements Runnable {

    SecondTaskWaitAndNotify task ;

    SecondConsumeRunnable(SecondTaskWaitAndNotify task){
        this.task = task ;
    }
    public void run(){

        try {
            Thread.sleep(1000);
            task.consume();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
