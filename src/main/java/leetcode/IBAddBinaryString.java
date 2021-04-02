package leetcode;

public class IBAddBinaryString {

    public String appendString(String s,int n){
        int len = s.length()-1 ;
        for(;len<n;len++){
            s+="0";
        }
        return  s;
    }




    public String addBinaryString(String a,String b){

        StringBuffer buffer = new StringBuffer(a) ;
        StringBuffer buffer1 = new StringBuffer(b) ;

        String a1 = buffer.reverse().toString() ;
        String b1 = buffer1.reverse().toString() ;

        int n = (a1.length()>b1.length())?a1.length():b1.length();
        String s1 = appendString(a1,n) ;
        String s2 = appendString(b1,n) ;
        int carryVal=0 ;
        String ans = "" ;
        for(int i=0;i<n;i++){
                int x = s1.charAt(i)-'0' ;
                int y = s2.charAt(i)-'0' ;

                if((x+y+carryVal)%2==1){
                    ans+="1" ;
                 //   carryVal = carryVal/2 ;
                }else{
                    ans+="0" ;
                  //  carryVal = carryVal/2 ;
                }
                carryVal = (carryVal+x+y)/2 ;
        }

        while(carryVal>0){
            if(carryVal%2==1){
                ans+="1" ;

            }else {
                ans = ans +"0" ;
            }
            carryVal = carryVal/2 ;
        }

        buffer = new StringBuffer(ans) ;
        return buffer.reverse().toString() ;
    }


    public static void main(String[] args) {
        String a = "10001" ;
        String b = "10010" ;

        IBAddBinaryString addBinaryString = new IBAddBinaryString() ;
        System.out.println(addBinaryString.addBinaryString(a,b)) ;
    }
}
