package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ThirdCriticalSection {
    private List<Integer> list = new ArrayList<Integer>() ;
    private static final int LOWER_LIMT = 0 ;
    private static final int UPPER_LIMT = 5 ;
    private Object lock = new Object() ;
     void produce(int value){
        if(list.size()>=UPPER_LIMT){
            synchronized (lock){
                System.out.println("waiting for consumer");
                try {
                    lock.wait();
                }catch (Exception e){

                }

            }
        }else{
            list.add(value);
           // lock.notify();
        }
    }

    void consume(){

         synchronized (lock){
             while (list.size()!=LOWER_LIMT){
                 System.out.println("consuming value "+list.get(list.size()-1));
                 list.remove(list.size()-1) ;
             }
             lock.notify();
         }


    }






}
