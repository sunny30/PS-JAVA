package facebook;

import java.util.Stack;

public class longestValidParathesisString {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()] ;
        Stack<Integer> stack = new Stack<Integer>() ;
        dp[0]=0 ;
        int ans = 0 ;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                stack.push(i);
                dp[i] = 0 ;
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty()==true){
                    dp[i] = 0 ;
                }else{
                    int pop = stack.pop() ;
                    dp[i] = i-pop+1 + (pop>0?dp[pop-1]:0 );
                    ans = Math.max(dp[i],ans) ;
                }
            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        longestValidParathesisString validParathesisString = new longestValidParathesisString() ;
        String input = ")()())" ;
        String input1 = "(()" ;
        System.out.println(validParathesisString.longestValidParentheses(input1)) ;
    }
}
