package facebook;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new SortByEnd());
        int arrows = 0 ;
        int pos = -1;
        for(int i=0;i<points.length;i++){
            if(i==0){
                arrows=1 ;
                pos = points[i][1] ;
            }else{
                if(points[i][0]<=pos)
                    continue;
                pos = points[i][1] ;
                arrows++ ;
            }
        }
        return arrows ;
    }


    class SortByEnd implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1]-o2[1] ;
        }
    }

    public static void main(String[] args) {

    }
}
