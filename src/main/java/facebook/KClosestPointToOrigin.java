package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(K,new MaxQueueCriterion()) ;
        int[][] ans = new int[K][2] ;
        for(int i=0;i<K;i++){
            queue.add(points[i]) ;
        }

        for(int i=K;i<points.length;i++){
            int dis = points[i][0]*points[i][0]+ points[i][1]*points[i][1] ;
            int peekdis = queue.peek()[0]*queue.peek()[0]+queue.peek()[1]*queue.peek()[1] ;
            if(dis<peekdis){
                queue.poll() ;
                queue.add(points[i]) ;
            }
        }
        int j=0;
        for(int[] i:queue){
            ans[j] = i ;
            j++ ;
        }
        return ans ;

    }

    class MaxQueueCriterion implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o2[0]*o2[0]+o2[1]*o2[1])-(o1[0]*o1[0]+o1[1]*o1[1]) ;
        }
    }

    public static void main(String[] args) {

    }
}
