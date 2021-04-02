package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);

        int n = A.size();
        int ai = n - 1;
        int bi = n - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int st = 0;
        while (st < n) {
            ans.add(A.get(ai) + B.get(bi));
            if (A.get(ai) + B.get(bi - 1) > A.get(ai - 1) + B.get(bi)) {
                bi--;
                st++;
            } else if (A.get(ai) + B.get(bi - 1) < A.get(ai - 1) + B.get(bi)) {
                ai--;
                st++;
            } else if (A.get(ai) + B.get(bi - 1) == A.get(ai - 1) + B.get(bi)) {
                ans.add(A.get(ai) + B.get(bi - 1));
                ans.add(A.get(ai - 1) + B.get(bi));
                ai--;
                bi--;
                st += 2;
                if(st>=n){
                    new ArrayList<Integer>(ans.subList(0,n-1)) ;
                }
            }

        }


        return new ArrayList<Integer>(ans.subList(0,n-1));
    }
}