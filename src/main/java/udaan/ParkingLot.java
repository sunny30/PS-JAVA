package udaan;

import java.util.*;

public class ParkingLot {

    private List<ParkingSlot> space;
    private Integer totalCapacity;
    private Integer carCapacity;
    private Integer twoWheelerCapacity;

    Map<String, ParkingSlot> index = new HashMap<String, ParkingSlot>();
    Map<VehicleType, Queue<ParkingSlot>> availableQueue = new HashMap<VehicleType, Queue<ParkingSlot>>();
    Set<String> users = new HashSet<String>() ;


    ParkingLot(Integer totalCapacity, Integer carCapacity, Integer twoWheelerCapacity, List<String> twowheeler, List<String> carwheeler) {

        this.totalCapacity = totalCapacity;
        this.carCapacity = carCapacity;
        this.twoWheelerCapacity = twoWheelerCapacity;
        initAvailability();
        initLayout(totalCapacity,twowheeler,carwheeler);
    }

    public void initLayout(Integer totalCapacity, List<String> twoWheelerSlot, List<String> carwheeler) {

        space = new ArrayList<ParkingSlot>();
        for (int i = 0; i < totalCapacity; i++) {

            ParkingSlot parkingSlot = new ParkingSlot(String.valueOf(i), VehicleType.UNDEFINED);
            parkingSlot.setIsOccupied(false);
            space.add(parkingSlot);
            index.put(String.valueOf(i), parkingSlot);
        }

        for (String key : twoWheelerSlot) {
            if (index.containsKey(key)) {
                index.get(key).setSlotType(VehicleType.TWO_WHEELER);
                availableQueue.get(VehicleType.TWO_WHEELER).add(index.get(key));
            }
        }

        for (String key : carwheeler) {
            if (index.containsKey(key)) {
                index.get(key).setSlotType(VehicleType.CAR);
                availableQueue.get(VehicleType.CAR).add(index.get(key));
            }
        }
    }


    void initAvailability() {
        for (VehicleType vehicleType : VehicleType.values()) {
            Queue<ParkingSlot> parkingSlots = new ArrayDeque<ParkingSlot>();
            availableQueue.put(vehicleType, parkingSlots);
        }
    }


    public  ParkingSlot acquireParking(VehicleType type,Long startTime,String vehicleId){
        ParkingSlot p =null ;
        if(users.contains(vehicleId)){
            System.out.println("Vehichle "+vehicleId+" already there");
        }
        else if(!availableQueue.get(type).isEmpty()){
            p = availableQueue.get(type).poll() ;
            p.setIsOccupied(true);
            BillingSystem.add(p,startTime);
            System.out.println(vehicleId+" alloted "+p.getSlotId()+" at "+startTime);
            users.add(vehicleId) ;
        }else{
            System.out.println("Parking not Available");
        }
        return p ;
    }


    public  void releaseParking(ParkingSlot p ,long endTime,String vehicleId){
        p.setIsOccupied(false);
        BillingSystem.computeAndRelaseParking(p,endTime);
        availableQueue.get(p.getSlotType()).add(p) ;
        users.remove(vehicleId) ;

    }


}
