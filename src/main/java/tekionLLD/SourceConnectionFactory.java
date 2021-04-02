package tekionLLD;

import java.util.Map;

public class SourceConnectionFactory {

    public  static Connection getConnection(String dbType, Map<String,String> connectionConfigs) throws Exception{

        if(dbType.equalsIgnoreCase("mysql"))
            return new MySQLConnection(connectionConfigs) ;
        else if(dbType.equalsIgnoreCase("dynamo")){
            return new MySQLConnection(connectionConfigs) ;
        }else{
            throw  new IllegalAccessException("dbType "+dbType+" connector not implented");
        }


    }
}
