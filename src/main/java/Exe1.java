import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe1 {

    public static void main(String[] args) throws Exception{

        System.out.println("hello");

        ExecutorService executors = Executors.newFixedThreadPool(6)  ;
        Exe1Task task = new Exe1Task(0) ;


        for(int i=0;i<6;i++){
            executors.execute(task);
            //executors.execute(task);

        }

        executors.shutdown();


    }
}
