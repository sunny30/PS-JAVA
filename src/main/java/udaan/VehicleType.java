package udaan;

public enum VehicleType {

    TWO_WHEELER("two_wheeler"),
    CAR("car"),
    UNDEFINED("undefined");


    private String symbol ;

    VehicleType(String symbol){
        this.symbol =symbol ;
    }

    public String toString(){
        return this.symbol ;
    }

}
