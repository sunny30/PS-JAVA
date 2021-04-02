package facebook;

import java.util.*;

public class MaximumApplesEaten {

    class SEPair{
        int count ;
        int start ;
        int end ;
        SEPair(int count,int start,int end){
            this.count =count ;
            this.start = start ;
            this.end = end ;
        }
    }
    public int eatenApples(int[] apples, int[] days) {

        int n=apples.length ;
        List<SEPair> list = new ArrayList<SEPair>() ;
        for(int i=0;i<n;i++){
            if(days[i]!=0){
                list.add(new SEPair(apples[i],i+1,i+1+days[i]));
            }else{
                list.add(new SEPair(0,i+1,i));
            }
        }

        PriorityQueue<SEPair> pq = new PriorityQueue<SEPair>(10,new SortC()) ;
        int ans = 0 ;
        for(int i=0;i<list.size();i++){
            if(list.get(i).count!=0 && list.get(i).start<list.get(i).end)
                pq.add(list.get(i)) ;

            while (!pq.isEmpty() && i+1>=pq.peek().end)
                pq.poll() ;
            if(!pq.isEmpty()){
                ans+=1 ;
                pq.peek().count = pq.peek().count-1 ;
                if(pq.peek().count==0)
                    pq.poll() ;
            }

        }

        int i =apples.length ;

        while(!pq.isEmpty()){
            while (!pq.isEmpty() && i+1>=pq.peek().end)
                pq.poll() ;
            if(!pq.isEmpty()){
                ans+=1 ;
                pq.peek().count = pq.peek().count-1 ;
                if(pq.peek().count<=0)
                    pq.poll() ;
            }
            i++ ;
        }






       // ans+=ce-cs+1 ;
        return ans ;
    }


    class SortC implements Comparator<SEPair>{
        public int compare(SEPair p1,SEPair p2){
            return p1.end-p2.end ;
        }
    }

    public static void main(String[] args) {
        int[] apples = {1,2,3,5,2} ;
        int[] days = {3,2,1,4,2} ;

        int[] apples1 = {2,1,10} ;
        int[] days1 = {2,10,1} ;

        MaximumApplesEaten maximumApplesEaten = new MaximumApplesEaten() ;
        System.out.println(maximumApplesEaten.eatenApples(apples,days)) ;
    }
}
