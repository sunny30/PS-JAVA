package designPattern;

public class SingleA {

    private static SingleA obj;
    private SingleA(){}

    public static SingleA getA(){
        if (obj == null){
            synchronized(SingleA.class){
                if (obj == null){
                    obj = new SingleA();//instance will be created at request time
                }
            }
        }
        return obj;
    }

    public void doSomething(){
        Constsnts.RideStatus rideStatus = Constsnts.RideStatus.BOOKED ;
        //write your code
    }
}
