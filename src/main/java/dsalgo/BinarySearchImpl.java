package dsalgo;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchImpl {

    public static void main(String[] args) {

        Integer[] arr = new Integer[5] ;
        arr[0] = 10 ;arr[1] = 14 ;arr[2] = 13 ; arr[3] = 11 ;arr[4] = 8 ;
        Arrays.sort(arr,new SortCriterion());

        int res = Arrays.binarySearch(arr,14) ;
        System.out.println(res);

        int res1 = lowerBound(arr,0,4,15) ;
        System.out.println(res1);

    }


    public static class SortCriterion implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2 ;
        }
    }

    public static int lowerBound(Integer[] arr,int low,int high,int key){
        int res  =0 ;
        while(low<=high){
            int mid = (low+high)/2 ;
            if(arr[mid]<key){
                low = mid+1 ;
                res =mid ;
            }else if(arr[mid]==key){
                high = mid-1 ;
                res = mid ;
            }else{
                high = mid-1 ;
            }
        }

        return res ;

    }
}
