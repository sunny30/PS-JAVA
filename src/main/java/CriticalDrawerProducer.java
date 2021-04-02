import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CriticalDrawerProducer {

    public static void main(String[] args) {
        ExecutorService producer = Executors.newSingleThreadExecutor() ;
        CriticalDrawerSection drawerSection = new CriticalDrawerSection();
        drawerSection.setAddval(2);
        producer.execute(drawerSection);

    }
}
