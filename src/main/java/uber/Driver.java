package uber;

import java.util.UUID;

public class Driver {


    public static void main(String[] args) {
        Driver driver = new Driver();
        KafkaMockQueue queue = driver.createQueue();
        Producer producer = new Producer("p1", queue);
        Consumer consumer1 = new Consumer("c1", queue, "first");
        Consumer consumer2 = new Consumer("c2", queue, "last");


        KafkaMockQueue queue1 = driver.createQueue() ;
        Producer producer1 = new Producer("p2", queue1);
        Consumer consumer3 = new Consumer("c3", queue1, "first");
        Consumer consumer4 = new Consumer("c4", queue1, "last");

        for (String sub : queue.getListOfConsumer()) {
            System.out.println("Current subscriber " + sub);
        }

        driver.triggerPublishEvent(producer);
        driver.triggerPublishEvent(producer);
        System.out.println("consumer1 polls data " + driver.triggerListeningQueue(consumer1));
        // driver.triggerListeningQueue(consumer2) ;
        System.out.println("consumer2 polls data " + driver.triggerListeningQueue(consumer2));
        //driver.triggerListeningQueue(consumer2) ;

        //driver.triggerListeningQueue(consumer1) ;
        System.out.println("consumer1 polls data " + driver.triggerListeningQueue(consumer1));
        driver.triggerPublishEvent(producer);
        driver.triggerPublishEvent(producer);
        System.out.println("consumer2 polls data " + driver.triggerListeningQueue(consumer2));
        queue.removeSubScriber("c1");
        System.out.println("consumer1 polls data " + driver.triggerListeningQueue(consumer1));

        for (String sub : queue.getListOfConsumer()) {
            System.out.println("Current subscriber " + sub);
        }


        driver.triggerPublishEvent(producer1);
        driver.triggerPublishEvent(producer1);
        System.out.println("consumer3 polls data " + driver.triggerListeningQueue(consumer3));
        // driver.triggerListeningQueue(consumer2) ;
        System.out.println("consumer4 polls data " + driver.triggerListeningQueue(consumer4));
        //driver.triggerListeningQueue(consumer2) ;

        //driver.triggerListeningQueue(consumer1) ;
        System.out.println("consumer3 polls data " + driver.triggerListeningQueue(consumer3));
        driver.triggerPublishEvent(producer);
        driver.triggerPublishEvent(producer);
        System.out.println("consumer4 polls data " + driver.triggerListeningQueue(consumer4));
        queue.removeSubScriber("c1");
        System.out.println("consumer3 polls data " + driver.triggerListeningQueue(consumer3));

        for (String sub : queue.getListOfConsumer()) {
            System.out.println("Current subscriber " + sub);
        }


    }


    public KafkaMockQueue createQueue() {
        KafkaMockQueue queue = new KafkaMockQueue();
        return queue;
    }

    public void triggerPublishEvent(Producer producer) {
        String data = UUID.randomUUID().toString() ;
        System.out.println(producer.getProducerId()+" is writing the data "+data);
        producer.pushData(data);

    }

    public String triggerListeningQueue(Consumer consumer) {
        return consumer.poll();
    }


}
