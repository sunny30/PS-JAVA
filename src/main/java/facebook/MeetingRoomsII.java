package facebook;

import java.util.*;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length ;
        List<Integer> time = new ArrayList<Integer>() ;
        Set<Integer> timeSet = new HashSet<Integer>() ;

        for(int i=0;i<len;i++){
            int st = intervals[i][0] ;
            int ed = intervals[i][1] ;

            if(!timeSet.contains(st)){
                time.add(st);
                timeSet.add(st) ;
            }

            if(!timeSet.contains(ed)){
                time.add(ed);
                timeSet.add(ed) ;
            }
        }

        Collections.sort(time);
        int[] nums =  new int[time.get(time.size()-1)] ;
        for(int i=0;i<nums.length;i++){
            nums[i] =0 ;
        }
        for(int i=0;i<len;i++){
            int st = intervals[i][0] ;
            int ed = intervals[i][1] ;

            nums[st]++ ;
            nums[ed]-- ;
        }
        int ans = 0 ;
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1] ;
            ans = Math.max(ans,nums[i]) ;
        }
        return ans ;
    }


}
