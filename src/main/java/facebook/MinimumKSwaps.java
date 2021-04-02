package facebook;

import java.util.ArrayList;
import java.util.List;

public class MinimumKSwaps {

    public int evaluate(List<Integer> list,int st,int ed,int mid){
        int numBehind = (mid-st) ;
        int numsAhead = (ed-mid) ;
        int subsum = (st>0?list.get(st-1):0) ;
        int midval = list.get(mid)-(mid>0?list.get(mid-1):0) ;
        int numBehindSum = ((mid>0)?(list.get(mid-1)-subsum):0) ;
        int numAheadSum = list.get(ed)-list.get(mid) ;
        int tans = numBehind*midval - numBehindSum - ((numBehind*(numBehind+1))/2) ;
        tans = tans+ numAheadSum-numsAhead*midval-(numsAhead*(numsAhead+1))/2 ;
        return tans ;
    }
    public int minMoves(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>() ;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                list.add(i) ;
        }
        int minMoves = Integer.MAX_VALUE ;
        for(int i=0;i<list.size();i++){
            if(i>0)
                list.set(i,list.get(i)+list.get(i-1)) ;
        }
        if(list.size()>0 && k==1)
            return 0 ;
        for(int i=k-1;i<list.size();i++){
            int st = i-k+1 ;
            int ed = i ;
            if(k%2==1){
                int mid = (st+ed)/2 ;
                int tans = evaluate(list,st,ed,mid) ;
                minMoves = Math.min(minMoves,tans) ;
            }else{
                int mid = (st+ed)/2 ;
                int tans = evaluate(list,st,ed,mid) ;
                minMoves = Math.min(minMoves,tans) ;
                tans = evaluate(list,st,ed,mid+1) ;
                minMoves = Math.min(minMoves,tans) ;

            }
        }
        return minMoves ;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,0,1} ;
        int k=2 ;
        MinimumKSwaps kSwaps = new MinimumKSwaps() ;
        System.out.println(kSwaps.minMoves(arr,k));
    }
}
