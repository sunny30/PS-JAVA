package concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class FifthCS {

    Semaphore semaphore = new Semaphore(3) ;
    List<Integer> input = new ArrayList<Integer>() ;

    public void produce(){
        try {
            System.out.println("available permits "+semaphore.availablePermits());
            semaphore.acquire();
            input.add(semaphore.availablePermits());
            System.out.println(input.get(input.size()-1));
            Thread.sleep(1000);

        }catch (Exception e){

        }finally {
            semaphore.release();
        }
    }
}
