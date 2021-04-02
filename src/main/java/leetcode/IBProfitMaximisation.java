package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IBProfitMaximisation {

    public Integer profitMaximisation(ArrayList<Integer> tickets, int c){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(c,new maxCriterion()) ;
        for(int i=0;i<tickets.size();i++)
            queue.add(tickets.get(i)) ;
        int ans = 0 ;
        for(int i =0;i<c;i++){
            int value = queue.poll() ;
            ans+=value ;
            value-- ;
            queue.add(value) ;
        }

        return ans ;

    }

    class maxCriterion implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1) ;
        }
    }

    public static void main(String[] args) {
        IBProfitMaximisation profitMaximisation = new IBProfitMaximisation() ;
        int[] arr =  {2,3} ;

       // System.out.println(profitMaximisation.profitMaximisation(arr,3));
    }
}
