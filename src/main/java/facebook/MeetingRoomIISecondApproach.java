package facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomIISecondApproach {

    class SortCriterion implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0] ;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        //Collections.sort(intervals,new SortCriterion());
        Arrays.sort(intervals,new SortCriterion());

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>() ;

        int count = 1 ;
        int len = intervals.length ;
        if(len==0)
            return 0 ;

        heap.add(intervals[0][1]) ;

        for(int i=1;i<len;i++){
           if(intervals[i][0]>=heap.peek()){
               heap.poll() ;
             //  heap.add(intervals[i][1]) ;
           }else{
               count++ ;
           }
           heap.add(intervals[i][1]) ;
        }
        return count ;
    }

    public static void main(String[] args) {
        int[][] input = {{9,14},{5,6},{3,5},{12,19}};
        MeetingRoomIISecondApproach secondApproach = new MeetingRoomIISecondApproach() ;
        secondApproach.minMeetingRooms(input);
    }
}
