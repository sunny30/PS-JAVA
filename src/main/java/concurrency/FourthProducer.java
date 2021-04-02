package concurrency;

public class FourthProducer implements Runnable{
    FourthCS cs ;

    FourthProducer(FourthCS cs){
        this.cs = cs ;
    }

    public void run(){

        while (true){
            cs.produce();
        }
    }

}
