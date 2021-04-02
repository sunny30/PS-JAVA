package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class IBCountTheTriangles {

    public Integer countTheTriangles(ArrayList<Integer> input){
        Collections.sort(input);
        int n = input.size() ;
        Integer ans = 0 ;
        for(int i=n-1;i>1;i--){
            ans += twoPointer(i,input) ;
        }
        return ans ;
    }

    public Integer twoPointer(int bigVerticeIndex,ArrayList<Integer> input){
        int st = 0 ;
        int lt = bigVerticeIndex-1 ;
        Integer target = input.get(bigVerticeIndex) ;
        int ans = 0 ;
        while(st<lt){
            Integer first = input.get(st) ;
            int last = input.get(lt) ;

            if(first+last>target){
                ans+=lt-st ;
                lt-- ;
            }else{
                st++ ;
            }
        }
        return ans ;
    }

    public static void main(String[] args) {

        IBCountTheTriangles countTheTriangles = new IBCountTheTriangles() ;
        ArrayList<Integer> input = new ArrayList<Integer>() ;
      //  input.add(1) ;input.add(1) ;input.add(1) ;
     //   input.add(2) ;input.add(2) ;
        Integer arr[] = { 10, 21, 22, 100, 101, 200, 300 } ;
        Collections.addAll(input,arr) ;
        System.out.println(countTheTriangles.countTheTriangles(input));
    }
}
