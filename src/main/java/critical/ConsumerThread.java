package critical;

public class ConsumerThread implements Runnable{

    private CriticalCounterSection section ;
    private int subVal ;

    ConsumerThread(CriticalCounterSection section,int subVal){
        this.section = section ;
        this.subVal = subVal ;
    }
    public void run(){
        section.withDrawMoney(subVal);
    }
}
