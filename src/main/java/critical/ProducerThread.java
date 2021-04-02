package critical;

public class ProducerThread implements Runnable {
    CriticalCounterSection section ;
    int addVal ;
    ProducerThread(CriticalCounterSection section,int addVal){
        this.section = section ;
        this.addVal = addVal ;
    }


    public void run(){
        section.depositMoney(addVal);
    }

}
