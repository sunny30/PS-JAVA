package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class IBWindowDistinctCount {

    public ArrayList<Integer> distictWindow(ArrayList<Integer> input,int k){
        int n = input.size();
        int st=0;
        int last = Math.min(k-1,n-1) ;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
        ArrayList<Integer> ans = new ArrayList<Integer>() ;
        int cnt = 0 ;
        for(int i=st;i<=last;i++){
            if(!map.containsKey(input.get(i))){
                cnt++ ;
                map.put(input.get(i),1) ;
            }else{
                map.put(input.get(i),map.get(input.get(i))+1) ;
            }
        }
        ans.add(cnt) ;
        last++ ;
        for(;last<n;last++){
            if(last-st+1>k){
                if(map.get(input.get(st))==1){
                    cnt-- ;
                    map.put(input.get(st),0) ;
                }else{
                    map.put(input.get(st),map.get(input.get(st))-1) ;
                }
                st++ ;
            }
            if(!map.containsKey(input.get(last)) || map.get(input.get(last))==0){
                cnt++ ;
                map.put(input.get(last),1) ;
            }else{
                map.put(input.get(last),map.get(input.get(last))+1) ;
            }

            if(last-st+1==k){
                ans.add(cnt) ;
            }
        }

        return ans ;
    }


    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>() ;
        IBWindowDistinctCount distinctCount = new IBWindowDistinctCount() ;
        input.add(1);input.add(2);input.add(1) ;
        input.add(3);input.add(4);input.add(3) ;

        ArrayList<Integer> ans = distinctCount.distictWindow(input,1) ;
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}


