package facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumParenthsiesToRemove {
    public String minRemoveToMakeValid(String s) {
        int ps = 0  ;
        Stack<Integer> st = new Stack<Integer>() ;
        Set<Integer> set = new HashSet<Integer>() ;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(i) ;
            else if(s.charAt(i)==')'){
                if(!st.isEmpty())
                    st.pop() ;
                else{
                    set.add(i) ;
                }
            }
        }

        while(!st.isEmpty()){
            set.add(st.peek()) ;
            st.pop() ;
        }
        String ans = "" ;
        for(int i=0;i<s.length();i++){
            if(!set.contains(i))
                ans = ans+s.charAt(i) ;
        }

        return ans ;

    }


    public static void main(String[] args) {
        MinimumParenthsiesToRemove remove = new MinimumParenthsiesToRemove() ;
        System.out.println(remove.minRemoveToMakeValid("lee(t(c)o)de)")) ;
        System.out.println(remove.minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(remove.minRemoveToMakeValid("))(("));
        System.out.println(remove.minRemoveToMakeValid("a)b(c)d"));
    }
}
