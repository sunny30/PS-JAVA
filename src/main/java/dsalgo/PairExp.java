package dsalgo;

import java.util.HashMap;

public class PairExp {


    public static void main(String[] args) {
        Pair<Integer,Integer> pair = new Pair<Integer, Integer>(3,4) ;
        HashMap<Pair<Integer,Integer>,Boolean> pairmap = new HashMap() ;

        pairmap.put(pair,true) ;

        Pair<Integer,Integer> pair1 = new Pair<Integer, Integer>(3,4) ;

        System.out.println(pairmap.containsKey(pair1));
    }
}


class Pair<T,O> {
    T a ;
    O b ;

    Pair(T a, O b){
        this.a =a ;
        this.b =b ;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Pair){
            Pair p = (Pair)o ;
            if(p.a==a && p.b==b){
                return true;
            }
         }
        return false ;
    }

    @Override
    public int hashCode() {
        return 31*a.hashCode()+b.hashCode();
    }
}
