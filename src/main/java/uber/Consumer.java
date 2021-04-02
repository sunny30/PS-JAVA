package uber;

import java.util.List;

public class Consumer {


    private String consumerId;
    private Integer currentOffset;
    private KafkaMockQueue queue;

    private List<KafkaMockQueue> queues ;


    private String subscriptionType;//this will set offset Accordingly
    private boolean initSetupdone;


    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(Integer currentOffset) {
        this.currentOffset = currentOffset;
    }

    public KafkaMockQueue getQueue() {
        return queue;
    }


    Consumer(String consumerId, KafkaMockQueue queue, String subscriptionType) {
        this.consumerId = consumerId;
        this.queue = queue;
        this.subscriptionType = subscriptionType;
        setInitialoffSet(subscriptionType);
        queue.addSubscriber(consumerId);
    }

    private void setInitialoffSet(String subscriptionType) {

        this.currentOffset = 0;

    }

    public String poll() {
        if (queue.isValidSubsCriber(consumerId)) {
            if (subscriptionType.equalsIgnoreCase("first")) {
                String data = queue.getData(currentOffset);
                this.currentOffset++;
                return data;
            } else if (subscriptionType.equalsIgnoreCase("last")) {
                this.currentOffset = queue.getSize() - 1;
                String data = queue.getData(currentOffset);
                this.currentOffset--;
                return data;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
