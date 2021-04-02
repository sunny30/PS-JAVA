package leetcodeuber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianDolls {

    class Pair{
        Integer w ;
        Integer h ;

        Pair(Integer w,Integer h){
            this.w = w ;
            this.h = h ;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length ;
        List<Pair> dolls = new ArrayList<Pair>() ;
        for(int i=0 ; i< len ;i++){
            Pair pair = new Pair(envelopes[i][0],envelopes[i][1]) ;
            dolls.add(pair);
        }
        Collections.sort(dolls,new SortCriterion());
        List<Integer> height = new ArrayList<Integer>() ;
        height.add(dolls.get(0).h);
        for(int i = 1 ; i<dolls.size();i++){
            //if(dolls.get(i).w!=dolls.get(i-1).w)
                height.add(dolls.get(i).h);
           // else
              //  height.set(height.size()-1,dolls.get(i).h) ;
        }
        List<Integer> dp = new ArrayList<Integer>() ;
       // dp.add(height.get(0));

//        for(int i=1;i<height.size();i++){
//            lowerBound(dp,height.get(i));
//        }

        int gans =1 ;
        for(int i=0;i<dolls.size();i++){
            dp.add(1);
        }

        for(int i=0;i<dolls.size();i++){
            int ans =dp.get(i) ;
            for(int j=0;j<i;j++){
                if(dolls.get(i).w>dolls.get(j).w && dolls.get(i).h>dolls.get(j).h){
                     ans = Math.max(ans,dp.get(j)+1) ;
                     dp.set(i,ans) ;
                     gans = Math.max(dp.get(i),gans) ;
                }
            }
        }



        return gans ;
    }

    public static void lowerBound(List<Integer> dp,int key){
        if(key>dp.get(dp.size()-1)){
            dp.add(key);
            return ;
        }else{
            int res = -1 ;
            int low = 0 ;
            int high = dp.size()-1 ;
            while(low<=high){
                int mid = (low+high)/2 ;
                if(dp.get(mid)<key){
                    res = mid ;
                    low = mid+1 ;
                }else if(dp.get(mid)==key){
                    res = mid ;
                    return ;
                }else{
                    high = mid-1 ;
                }
            }
            if(dp.get(res+1)>key)
                dp.set(res+1,key) ;
        }
    }

    class SortCriterion implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.w.compareTo(o2.w)==0)
                return o1.h.compareTo(o2.h) ;
            else
                return o1.w.compareTo(o2.w) ;
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {2,10},{5,4},{6,5},{6,7},{2,3}
        } ;

        RussianDolls dolls = new RussianDolls() ;
        System.out.println(dolls.maxEnvelopes(input)) ;
    }
}
