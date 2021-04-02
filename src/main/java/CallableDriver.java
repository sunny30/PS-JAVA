import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDriver {


    public static void main(String[] args)throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5) ;
        CallableTask task = new CallableTask(0) ;
        List<Future<Integer>> results = new ArrayList() ;
        for(int i=0;i<5;i++){
            Future<Integer> result = executorService.submit(task) ;
            results.add(result) ;
        }

        for(int i=0;i<5;i++){
            System.out.println(results.get(i).get()) ;
        }
        executorService.shutdown();
    }
}
