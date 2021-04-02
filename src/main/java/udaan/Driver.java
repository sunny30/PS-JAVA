package udaan;

import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        Integer total = 5 ;
        String[] car = {"1-0","1-3"} ;
        String[] twoWheelers  = {"2","1","4"} ;
        List<String> carList = Arrays.asList(car) ;
        List<String> tList = Arrays.asList(twoWheelers) ;

        ParkingLot lot = new ParkingLot(5,carList.size(),tList.size(),tList,carList) ;

        BillingSystem.alterRates(VehicleType.CAR,10L);
        BillingSystem.alterRates(VehicleType.TWO_WHEELER,5L);


        ParkingSlot p1 = lot.acquireParking(VehicleType.CAR,10L,"v1") ;
        ParkingSlot p2 = lot.acquireParking(VehicleType.TWO_WHEELER,11L,"v9") ;
        ParkingSlot p3 = lot.acquireParking(VehicleType.CAR,12L,"v1") ;
        ParkingSlot p4 = lot.acquireParking(VehicleType.TWO_WHEELER,13L,"v2") ;
        ParkingSlot p5 = lot.acquireParking(VehicleType.CAR,14L,"v4") ;
        ParkingSlot p6 = lot.acquireParking(VehicleType.TWO_WHEELER,15L,"v5") ;

        lot.releaseParking(p1,16L,"v1");

        ParkingSlot p7 = lot.acquireParking(VehicleType.CAR,17L,"v1") ;
        ParkingSlot p8 = lot.acquireParking(VehicleType.CAR,17L,"v1") ;
    }
}
