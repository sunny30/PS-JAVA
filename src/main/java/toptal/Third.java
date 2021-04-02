package toptal;

import java.util.HashMap;
import java.util.Map;

public class Third {

    public int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 8
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("January", 0);
        map.put("February", 1);
        map.put("March", 2);
        map.put("April", 3);
        map.put("May", 4);
        map.put("June", 5);
        map.put("July", 6);
        map.put("August", 7);
        map.put("September", 8);
        map.put("October", 9);
        map.put("November", 10);
        map.put("December", 11);

        String[] weekdays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"} ;
        int ans = 0 ;
        int ddbreak = 0 ;
        int edbreak = 0 ;
        int dayOfS = -1 ;
        if(Y%4==0){
            int x = map.get(A) ;
            int y = map.get(B) ;
            for(int i=0;i<x;i++){
                ddbreak += leapDays[i] ;
            }

            for(int i=0;i<=y;i++){
                edbreak+=leapDays[i] ;
            }
            for(int i=0;i<weekdays.length;i++){
                if(weekdays[i].equalsIgnoreCase(W)){
                    dayOfS = i ;
                    break ;
                }
            }
            int mos = (ddbreak%7+dayOfS+1)%7 ;
            int daysAfter = (-mos)%7 ;
            int totalDays = edbreak-ddbreak-daysAfter ;
            return totalDays/7 ;



        }else{

            int x = map.get(A) ;
            int y = map.get(B) ;
            for(int i=0;i<x;i++){
                ddbreak += days[i] ;
            }

            for(int i=0;i<=y;i++){
                edbreak+=days[i] ;
            }
            for(int i=0;i<weekdays.length;i++){
                if(weekdays[i].equalsIgnoreCase(W)){
                    dayOfS = i ;
                    break ;
                }
            }
            int mos = (ddbreak%7+dayOfS+1)%7 ;
            int daysAfter = (-mos)%7 ;
            int totalDays = edbreak-ddbreak-daysAfter ;
            return totalDays/7 ;

        }


    }
}
