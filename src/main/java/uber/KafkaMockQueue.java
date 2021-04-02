package uber;

import java.util.*;

public class KafkaMockQueue {

    private List<String>  storage = new ArrayList<String>() ;
    private Map<String,Boolean> subscribers = new HashMap<String,Boolean>() ;
    private String queueId ;

    public KafkaMockQueue(){
        queueId = UUID.randomUUID().toString() ;
    }

    public Integer getSize(){
        return this.storage.size() ;
    }
    // make it thread safe with write lock in Executors pattern
    public boolean addSubscriber(String consumerId){
        try {
            subscribers.put(consumerId,true) ;
            return true ;
        }catch (Exception e){
            return false ;
        }
    }
    // make it thread safe with write lock in Executors pattern
    public Boolean removeSubScriber(String consumerId){
        try {
            subscribers.put(consumerId,false) ;
            return true ;
        }catch (Exception e){
            return false ;
        }
    }
    //read under read lock in multithreaded application
    public List<String> getListOfConsumer(){
        List<String> subscriberList = new ArrayList<String>() ;
        for(String subscriber: subscribers.keySet()){
            if(subscribers.get(subscriber)){
                subscriberList.add(subscriber);
            }
        }
        return subscriberList ;
    }
    //read under read lock in multithreaded application
    public String getData(Integer offset){
        if(offset<storage.size()){
            return storage.get(offset) ;
        }else{
            return null ;
        }
    }

    //to do make it thread safe
    public void addData(String data){
        this.storage.add(data);
    }

    public boolean isValidSubsCriber(String subscriberId){
        if(!subscribers.containsKey(subscriberId)){
            return false ;
        }else{
            return subscribers.get(subscriberId) ;
        }
    }


}
