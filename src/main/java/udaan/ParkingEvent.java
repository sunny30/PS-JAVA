package udaan;

public class ParkingEvent {

    private String lotId ;
    private Long startingTime ;
    private Long endTime ;
    private Long totalBill ;


    ParkingEvent(String lotId,Long startingTime,Long endTime,Long totalBill){
        this.lotId = lotId ;
        this.startingTime = startingTime ;
        this.endTime = endTime ;
        this.totalBill = totalBill ;
    }


}
