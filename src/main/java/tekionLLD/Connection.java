package tekionLLD;

import java.util.HashMap;
import java.util.Map;

public abstract class Connection {

    public String dbType ;
    public void setConnectionDetails(Map<String, String> connectionDetails) {
        this.connectionDetails = connectionDetails;
    }

    private  Map<String,String> connectionDetails = new HashMap<String,String>() ;


    Connection(Map<String,String> connctionDetails){
        this.connectionDetails = connctionDetails;
    }

    Connection(){

    }


    public String getMetaInfo(String key){
        if(connectionDetails.containsKey(key))
               return connectionDetails.get(key) ;
        else
            return null ;
    }

    public abstract String getReadQueries(String waterMark,String lastTime,String customerName);

    public abstract boolean getConnection();

    public abstract String connectionString() ;





}
