package uber;

public class Producer {

    public String getProducerId() {
        return producerId;
    }

    private String producerId  ;
    private KafkaMockQueue queue ;

    Producer(String producerId, KafkaMockQueue queue){
        this.producerId = producerId ;
        this.queue = queue ;
    }


    public void pushData(String data){
        queue.addData(data);
    }


}
