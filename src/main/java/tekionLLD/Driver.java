package tekionLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {


    public static void main(String[] args) throws Exception{

        Config config = initConfigs() ;
        Map<String,String> sourceConnections = readConfigs("") ;
        Connection connection = SourceConnectionFactory.getConnection("mysql",sourceConnections) ;
        String tableName = sourceConnections.get("tableName") ;
        String newWaterMarkValue = sourceConnections.get("instructedtime") ;
        String waterMark = WaterMarkStorage.getCurentWaterMark(tableName);
        SourceReader reader = new SourceReader(connection,waterMark,newWaterMarkValue) ;//water ma
        reader.readSource();
        Connection targetConnections = SourceConnectionFactory.getConnection("mysql",sourceConnections) ;
        TransformationEngine spark = new TransformationEngine() ;

        List<String> cons = customTransformation("") ;
        CustomTransformation transformation = new CustomTransformation(cons,spark) ;
        //transformation.applyTransformations();
        SourceWriter writer = new  SourceWriter(targetConnections,transformation) ;
        writer.exportData();
        //String tableName = sourceConnections.get("table") ;

        //watermark updation will only happen once the complete ETL is complete else it may cause data loss in subsequent pipeline run. because ETL can fail at any step E,T,L
        WaterMarkStorage.updateWaterWark(tableName,newWaterMarkValue);


    }


    public static  Map<String,String > readConfigs(String path){

        Map<String,String> map = new HashMap<String,String>() ;
        map.put("dbName","finance") ;
        map.put("dealer", "A") ;
        map.put("host","host") ;
        map.put("port","port") ;
        map.put("tableName","table") ;
        map.put("userName","u1") ;
        map.put("password","p1") ;
        map.put("instructedtime","30-05-1999") ;


        return map ;
    }
    //Mock lib
    public static  HashMap<String,String > getSourceConfigs(){

        HashMap<String,String> map = new HashMap<String,String>() ;
        map.put("dbName","finance") ;
        map.put("dealer", "A") ;
        map.put("host","host") ;
        map.put("port","port") ;
        map.put("tableName","table") ;
        map.put("userName","u1") ;
        map.put("password","p1") ;
        map.put("instructedtime","30-05-1999") ;


        return map ;
    }

    public static List<String> customTransformation(String key){
        List<String> conList = new ArrayList<String>() ;
        conList.add("c1");
        conList.add("c2");
        return conList ;
    }

    public static String getConfigValues(String key,Map<String,String> configs){
        return configs.get(key) ;
    }

    //Dealer = A
        //SourceConnections :
    //        Source:

    //

    public static Config initConfigs(){
        Config config = new Config() ;
        config.addDealer("A");
        String key = "A,C1" ; // A is the dealer name and C1 is the transaction Id on which both source and target gets Map
        config.updateCompleteTransformations(key,customTransformation(key));
        HashMap<String,String> sourceConnection = getSourceConfigs() ;
        config.updateSourceSourceConnections(key,sourceConnection);
        HashMap<String,String> targetConnection = getSourceConfigs() ;
        config.updateTargetConnections(key,targetConnection);
        return config;
    }

}
