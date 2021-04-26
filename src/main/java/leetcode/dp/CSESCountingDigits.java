package leetcode.dp;

import java.util.ArrayList;

public class CSESCountingDigits {

    public long power9(int exponent) {
        int curr = 9;
        for (int i = 2; i <= exponent; i++) {
            curr = curr * 9;

        }
        return curr;
    }

    public long getTotalInNDigit(int n) {
        int curr = 9;
        long sum = 9;
        for (int i = 2; i <= n; i++) {
            curr = curr * 9;
            sum += curr;
        }
        return sum;
    }

    public ArrayList<Long> getIndexWiseInt(long n) {
        ArrayList<Long> index = new ArrayList<Long>();
        long n1 = 0;
        while (n > 0) {
            n1 = n % 10;
            index.add(n1);
            n = n / 10;
        }

        return index;


    }

    public boolean checkValidTest(ArrayList<Long> index) {
        boolean valid = true;

        for (int i = 0; i < index.size() - 1; i++) {
            if (index.get(i) == index.get(i + 1))
                valid = false;
        }
        return valid;

    }

    public long unitTest(long n, long m) {
        long cnt = 0;

        for (long i = n; i <= m; i++) {
            ArrayList<Long> index = getIndexWiseInt(i);
            if (checkValidTest(index))
                cnt++;
        }
        return cnt;
    }


    public long solve(ArrayList<Long> indexList, boolean first, int index, long prev,long ans) {
        int start = 0 ;
        if(index==0){
            if(first)
                start=1 ;
            for(int i=start;i<=start;i++){
                if(i!=prev){
                    ans++ ;
                }
            }
            return ans ;
        }
        int len = indexList.size();

        if(first) {
            ans += getTotalInNDigit(len - 1);
            start=1 ;
        }

        for(int i=start;i<indexList.get(index);i++){
            if(i!=prev)
                ans+=power9(index) ;

        }

        return solve(indexList,false,index-1,indexList.get(index),ans) ;


    }

    public static void main(String[] args) {
        CSESCountingDigits digits = new CSESCountingDigits();
        long n = 321 ;
        long n1 = 123 ;
        System.out.println(digits.unitTest(1L, n));
        ArrayList<Long> indexList = digits.getIndexWiseInt(n) ;
        ArrayList<Long> indexList1 = digits.getIndexWiseInt(n1) ;
        long ans = digits.solve(indexList,true,indexList.size()-1,-1,0L) ;
        long ans1 = digits.solve(indexList1,true,indexList1.size()-1,-1,0L) ;
        System.out.println(ans-ans1);

    }


}
