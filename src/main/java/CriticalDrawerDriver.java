import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CriticalDrawerDriver {

    public static void main(String[] args) throws Exception {
        // ExecutorService executorService = Executors.newFixedThreadPool(3);

        ExecutorService consumer = Executors.newFixedThreadPool(2);
        ExecutorService producer = Executors.newFixedThreadPool(2);


        CriticalDrawerSection drawerSection = new CriticalDrawerSection();
        //drawerSection.setDeposit(true);

        drawerSection.addval = 2;
        producer.execute(drawerSection);
        drawerSection.subval = -11;
        consumer.execute(drawerSection);



        producer.shutdown();
        consumer.shutdown();

        System.out.println(drawerSection.val);


    }
}
