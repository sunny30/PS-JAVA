package facebook;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<2)
            return 0 ;
        Arrays.sort(intervals,new SortByFinishTimes());
        int currentFinishTime = intervals[0][1] ;
        int count = 1 ;

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<currentFinishTime)
                continue;
            else{
                count++ ;
                currentFinishTime = intervals[i][1] ;
            }
        }
        return intervals.length-count ;
    }


    class SortByFinishTimes implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1]-o2[1] ;
        }
    }
}
