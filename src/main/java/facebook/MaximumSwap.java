package facebook;

public class MaximumSwap {

    public int maximumSwap(int num) {
        Integer a = num ;
        String s = a.toString();
        int len = s.length() ;
        int[] suffixMap = new int[len] ;
        suffixMap[len-1] = len-1 ;

        for(int i=len-1;i>=0;i--){
            if(i<len-1){
                int indexVal = s.charAt(i)-'0' ;
                int nextVal = s.charAt(suffixMap[i+1])-'0' ;
                if(indexVal<=nextVal)
                    suffixMap[i]=suffixMap[i+1] ;
                else
                    suffixMap[i] = i ;
            }
        }
        char[] ch = s.toCharArray() ;
        for(int i=0;i<len;i++){
            if(suffixMap[i]!=i && ch[i]!=ch[suffixMap[i]]){
                int val = suffixMap[i] ;
                char temp =  ch[val] ;

               ch[val] = ch[i] ;
                ch[i] = temp ;
                break;
            }
        }
        return Integer.parseInt(new String(ch)) ;
    }


    public static void main(String[] args) {
        int a = 2736 ;
        int b = 9973 ;
        int c = 98368 ;
        int d = 1993 ;
        MaximumSwap swap = new MaximumSwap() ;
        System.out.println(swap.maximumSwap(a)) ;
        System.out.println(swap.maximumSwap(b));
        System.out.println(swap.maximumSwap(c));
        System.out.println(swap.maximumSwap(d));
    }
}
