package udaan;

import java.util.HashMap;
import java.util.Map;

public class BillingSystem {
    private static Map<VehicleType,Long> rates = new HashMap<VehicleType,Long>() ;
    private static Map<String,Long> bills = new HashMap<String, Long>() ;

    public static void add(ParkingSlot p,Long starttime){

        if(bills.containsKey(p.getSlotId())){
            System.out.println("lot "+p.getSlotId()+" is occupied");
        }else{
            bills.put(p.getSlotId(),starttime) ;
        }
    }

    public static void alterRates(VehicleType v,Long rate){
        rates.put(v,rate);
    }

    public static void computeAndRelaseParking(ParkingSlot p,Long endTime){
        if(bills.containsKey(p.getSlotId())){
            Long st = bills.get(p.getSlotId()) ;
            Long duration = endTime-st ;
            Long totalBill = duration*rates.get(p.getSlotType()) ;
            System.out.println(p.getSlotId()+" has bill "+totalBill);
            ParkingEvent p1  = new ParkingEvent(p.getSlotId(),st,endTime,totalBill) ;
            ParkingWareHouse.add(p1);
            bills.remove(p.getSlotId()) ;
        }

    }




}
