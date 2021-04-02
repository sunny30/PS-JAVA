package leetcode;

import java.util.ArrayList;

public class KDiffTwoPointer {

    class Pair {
        Integer fi ;
        Integer li ;
        Pair(Integer fi, Integer li){
            this.fi = fi ;
            this.li = li ;
        }
    }

    public ArrayList<Pair> getKDiff(ArrayList<Integer> input,int k){
        int st=0 ;
        int last = 1 ;
        int n = input.size() ;
        ArrayList<Pair> pairs = new ArrayList<Pair>() ;

        for(;last<n;last++) {

            if (input.get(last) - input.get(st) == k) {
                Pair pair = new Pair(st, last);
                pairs.add(pair);
            } else if (input.get(last) - input.get(st) > k) {
                while (st < last && input.get(last) - input.get(st) > k) {
                    st++;
                }
                if (last!=st && input.get(last) - input.get(st) == k) {
                    Pair pair = new Pair(st, last);
                    pairs.add(pair);
                }
            }
        }
        return  pairs ;
    }
}


