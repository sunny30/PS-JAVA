package concurrency;

public class FourthConsumer implements Runnable {
    FourthCS cs ;
    FourthConsumer(FourthCS cs){
        this.cs = cs ;
    }

    public void run(){
        while (true){
            cs.consume();
        }
    }
}
