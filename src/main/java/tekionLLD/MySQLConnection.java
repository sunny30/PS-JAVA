package tekionLLD;

import java.util.HashMap;
import java.util.Map;

public class MySQLConnection extends Connection {
    private String userName;
    private String password;
    String db;
    String tableName;
    String hostName;
    String portName;

    MySQLConnection(String userName, String password, String db, String tableName, String hostName, String portName) {
        super();
        super.dbType = "mysql" ;
        this.db = db;
        this.userName = userName;
        this.password = password;
        this.tableName = tableName;
        this.hostName = hostName;
        this.portName = portName;

    }

    MySQLConnection(Map<String,String> map){
        this.setConnectionDetails(map);
        super.dbType="mysql" ;
        this.tableName = getMetaInfo("tableName") ;
        this.userName = getMetaInfo("userName");
        this.password = getMetaInfo("password");
        //this.tableName = tableName;
        this.hostName = getMetaInfo("host");
        this.portName = getMetaInfo("port");

    }


    public String connectionString() {
        //prepare read staement
        StringBuilder builder = new StringBuilder();
        return builder.append("jdbc:").append(hostName).append(portName).append(db).toString();
    }


    public boolean getConnection() {
        System.out.println("making connection to " + connectionString());
        return true;
    }

    public String getReadQueries(String watermark,String lastTime,String customerName){
        String query ="query" ;
        String connectionString = connectionString() ;
        if(getConnection()) {
            System.out.println("reading "+tableName+" for"+ customerName+" from mysql where"+" "+lastTime+" less than "+watermark);
            return query;
        }
        else
            return  null ;
    }
}
