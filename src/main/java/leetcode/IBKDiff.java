package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class IBKDiff {

    public Boolean kdiiff(int k, ArrayList<Integer> input) {

        if(k<0)
            k=-k;
        Collections.sort(input);

        int st = 0;
        int lt = 1;
        int n = input.size();

        if (input.size() > 0) {
            while (lt < n) {
                Integer lastP = input.get(lt);
                Integer startP = input.get(st);

                if (lastP - startP > k) {
                    st++;
                } else if (lastP - startP < k) {
                    lt++;
                } else if (lastP - startP == k && lt != st) {
                    return true;
                }

                if (lt == st)
                    lt++;

            }
        } else {
            return false;
        }

        return false ;

    }


    public static void main(String[] args) {
        IBKDiff kdiff = new IBKDiff() ;
        ArrayList<Integer> input = new ArrayList<Integer>() ;
        //  input.add(1) ;input.add(1) ;input.add(1) ;
        //   input.add(2) ;input.add(2) ;
        Integer arr[] = { 10, 21, 22, 100, 101, 200, 300 } ;
        Collections.addAll(input,arr) ;

        System.out.println(kdiff.kdiiff(-11,input));
    }
}
