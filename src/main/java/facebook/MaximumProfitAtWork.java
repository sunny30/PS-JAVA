package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProfitAtWork {

    class DPPair{
        int difficulty ;
        int profit ;

        DPPair(int _d,int _p){
            this.difficulty = _d ;
            this.profit = _p ;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        PriorityQueue<DPPair> q = new PriorityQueue<DPPair>(profit.length,new SortC()) ;

        for(int i=0;i<difficulty.length;i++){
            q.add(new DPPair(difficulty[i],profit[i])) ;
        }
        int ans = 0 ;
        int j = worker.length-1 ;
        while (!q.isEmpty() && j>=0){

            while (worker[j]<q.peek().difficulty){
                q.poll() ;
            }
            ans+=q.peek().profit ;
            j-- ;

        }
        return ans ;
    }


    class SortC implements Comparator<DPPair>{
        @Override
        public int compare(DPPair o1, DPPair o2) {
            return o2.profit-o1.profit ;
        }
    }
}
