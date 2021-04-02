package tekionLLD;

import java.util.HashMap;

public class WaterMarkStorage {

    private static HashMap<String,String> watermarkStorrage= new HashMap<String,String>() ;
    static {
        watermarkStorrage.put("table","22-05-1999") ;
        watermarkStorrage.put("table2","23-05-1999") ;
    }


    public static void updateWaterWark(String key,String value){
        watermarkStorrage.put(key,value) ;
    }

    public static String getCurentWaterMark(String tableName){
        return watermarkStorrage.get(tableName) ;
    }
}
