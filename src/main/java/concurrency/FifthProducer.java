package concurrency;

public class FifthProducer implements Runnable {
    FifthCS fifthCS;

    FifthProducer(FifthCS cs) {
        this.fifthCS = cs;
    }

    public void run() {
        fifthCS.produce();
    }
}
