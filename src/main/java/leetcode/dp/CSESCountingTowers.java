package leetcode.dp;

public class CSESCountingTowers {

    public int horizantal(int n){
        if(n==1)
            return 1 ;
        //total(n-1)+total(n-2)+total(n-3).....1
        return totalf(n-1) ;


    }


    public int vertical(int n){
        if(n==1)
            return 1 ;
        return 4*vertical(n-1)+horizantal(n-1) ;
    }

    public int total(int n){
        if(n==1)
            return 2 ;
        return horizantal(n)+vertical(n) ;
    }

    int totalf(int n){
        if(n==0)
            return 1 ;
        return totalf(n-1)+total(n) ;
    }


    public static void main(String[] args) {
        int n =6 ;
        CSESCountingTowers countingTowers = new CSESCountingTowers() ;
        System.out.println(countingTowers.total(n));
    }
}
