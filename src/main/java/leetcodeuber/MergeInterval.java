package leetcodeuber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    int currentIndex = 0;
    class Pair{
        Integer st ;
        Integer lt ;

        Pair(Integer w,Integer h){
            this.st = w ;
            this.lt = h ;
        }
    }

    public Pair searchOverlap(List<Pair> intervals,int pos,int st,int lt) {
        if(pos==intervals.size()) {
            currentIndex = pos;
            return new Pair(st, lt);
        }
        if(intervals.get(pos).st>lt){
            currentIndex = pos ;
            return new Pair(st,lt) ;
        }
      //  int tst = intervals.get(pos).st ;
        int tlt = Math.max(lt,intervals.get(pos).lt) ;

        return searchOverlap(intervals,pos+1,st,tlt) ;

    }

    public int[][] merge(int[][] intervals) {

        int len = intervals.length ;
        if(len==1)
            return intervals;
        List<Pair> intervals1 = new ArrayList<Pair>() ;
        for(int i=0 ; i< len ;i++){
            Pair pair = new Pair(intervals[i][0],intervals[i][1]) ;
            intervals1.add(pair);
        }

        Collections.sort(intervals1,new SortCriterion());
        List<Pair> results = new ArrayList<Pair>() ;
        while (currentIndex<intervals1.size()){
            Pair res = searchOverlap(intervals1,1,intervals1.get(currentIndex).st,intervals1.get(currentIndex).lt) ;
            results.add(res);
        }

        int[][] returnresults = new int[results.size()][2] ;

        for(int i =0 ; i<results.size();i++){
            returnresults[i][0] = results.get(i).st ;
            returnresults[i][1] = results.get(i).lt ;
        }

        return returnresults ;
    }


    class SortCriterion implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.st.compareTo(o2.st)==0)
                return o1.lt.compareTo(o2.lt) ;
            else
                return o1.st.compareTo(o2.st) ;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}} ;
        int[][] input1 = {{1,4},{4,5}} ;
        int[][] input2 = {{1,10},{4,5}} ;
        MergeInterval mergeInterval = new MergeInterval() ;
        int[][] res = mergeInterval.merge(input2) ;
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
