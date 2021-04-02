package udaan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingWareHouse {

    private static List<ParkingEvent> wareHouse = new ArrayList<ParkingEvent>() ;

    private static Map<String,List<ParkingEvent>> vehicleHistory = new HashMap<String, List<ParkingEvent>>() ;


    public static void  add(ParkingEvent p) {
        wareHouse.add(p);
    }
}
