package udaan;

public class ParkingSlot {



    private String lotId ;
    private VehicleType slotType ;

    private Boolean isOccupied ;

    ParkingSlot(String lotId,VehicleType slotType){
        this.lotId = lotId ;
        this.slotType = slotType ;
    }


    public String getSlotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public void setSlotType(VehicleType slotType) {
        this.slotType = slotType;
    }

    public void setIsOccupied(Boolean isOccupied){
        this.isOccupied = isOccupied ;
    }

}
