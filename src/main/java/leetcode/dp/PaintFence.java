package leetcode.dp;

public class PaintFence {

    int diff(int n,int k){
        if(n==1)
            return k;
        return (k-1)*(diff(n-1,k)+same(n-1,k)) ;
    }

    int same(int n,int k){
        if(n==1)
            return 0;
        if(n==2)
            return k ;
        return diff(n-1,k) ;


    }

    int total(int n,int k){
        return diff(n,k)+same(n,k) ;
    }

//    int f(int n,int k,int i){
//        if(i==2 && n==1)
//            return 0;
//        if(n==1)
//            return k ;
//
//        if(i==1){
//            return (k-1)*f(n-1,k,1) ;
//        }else{
//            return (k-1)*f(n-1,k,2)+f(n-1,k,1) ;
//        }
//    }


    public static void main(String[] args) {
        int n=5 ;
        int k= 4 ;
        PaintFence paintFence = new PaintFence() ;
        int x = paintFence.same(n,k) ;
        int y = paintFence.diff(n,k) ;
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+y);
    }
}
