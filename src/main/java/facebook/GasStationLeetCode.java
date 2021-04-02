package facebook;

public class GasStationLeetCode {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length ;
        int min = 0 ;
        int psum = 0 ;
        for(int i=0;i<len;i++){
            psum = psum+gas[i]-cost[i] ;
            min = Math.min(min,psum) ;
        }
        int ans = -1 ;
        psum=0 ;
        for(int i=len-1;i>=0;i--){
            psum = gas[i]-cost[i] ;
            min=min+psum ;
            if(min>=0) {
                return i;
            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,3,2,4,1,5,3,2,4} ;
        int[] cost = {1,1,1,3,2,4,3,6,7,4,3,1} ;
        GasStationLeetCode gasStationLeetCode = new GasStationLeetCode() ;
        System.out.println(gasStationLeetCode.canCompleteCircuit(gas,cost)) ;
    }
}
