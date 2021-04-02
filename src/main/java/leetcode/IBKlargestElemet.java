package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IBKlargestElemet {

    public ArrayList<Integer> getKLargestElement(ArrayList<Integer> A,int B){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(B,new MxCriterion()) ;
        for(int i=0;i<A.size();i++){
            priorityQueue.add(A.get(i)) ;
        }
        int cnt = 0 ;
        ArrayList<Integer> ans = new ArrayList<Integer>() ;
        while(cnt<B){
            ans.add(priorityQueue.poll()) ;
            cnt++;
        }
        return ans ;
    }


    public class MxCriterion implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1) ;
        }
    }


    public static void main(String[] args) {
        IBKlargestElemet ibKlargestElemet = new IBKlargestElemet() ;
        ArrayList<Integer> A = new ArrayList<Integer>() ;
        A.add(3) ;
        A.add(2) ;
        A.add(9) ;
        A.add(5) ;
        A.add(4) ;
        A.add(6) ;
        ArrayList<Integer> v = ibKlargestElemet.getKLargestElement(A,3) ;
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }

    }
}
