package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class GreedySeats {
    public static final int MOD = 10000003 ;
    public int compute(ArrayList<Integer> index,int median){
        int ans = 0 ;
        for(int i=median-1;i>=0;i--){
            int pos = index.get(median)-(median-i) ;
            ans = (ans + pos-index.get(i))%MOD ;
        }
        for(int i=median+1;i<index.size();i++){
            ans = (ans+Math.abs(index.get(median)+i-median-index.get(i)))%MOD ;
        }
        return ans ;
    }

    public int seatArrangements(String input){
        ArrayList<Integer> index = new ArrayList<Integer>() ;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='x'){
                index.add(i);
            }
        }
        if(index.size()%2==0){
            int med = index.size()/2-1 ;
            int med1 = med+1 ;
            return Math.min(compute(index,med),compute(index,med1)) ;
        }else{
            int med = index.size()/2 ;
            return compute(index,med) ;
        }
    }


    public static void main(String[] args) {
        String input ="....x..xx...x.." ;

        GreedySeats seats = new GreedySeats() ;
        System.out.println(seats.seatArrangements(input)) ;
    }
}
