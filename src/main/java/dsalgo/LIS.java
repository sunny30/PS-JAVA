package dsalgo;

import java.util.ArrayList;
import java.util.List;

public class LIS {

    public static void main(String[] args) {
        int n=7 ;
        Integer[] input = new Integer[7] ;
        input[0]=3 ;
        input[1]=1 ;
        input[2]=2 ;
        input[3]=9 ;
        input[4]=6 ;
        input[5]=5 ;
        input[6]=6 ;

        int[] a = {1,2,3} ;
        int[] b = a ;
        for(int i = 0 ;i<b.length;i++)
            System.out.println(b[i]);

        List<Integer> dp = new ArrayList<Integer>() ;
        dp.add(input[0]);

        for(int i=1;i<n;i++){
            lowerBound(dp,input[i]);
        }
        for(int i=0;i<dp.size();i++){
            System.out.print(dp.get(i));
        }
        System.out.println();
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
}
