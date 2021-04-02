package facebook;

import java.util.*;

public class RemoveInvalidParentheses {

    public Boolean isValidParentheses(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new TreeSet<String>();
        Set<String> visited = new HashSet<String>() ;
        visited.add(s) ;
        Queue<String> queue = new ArrayDeque<String>() ;
        boolean proceedtill = false ;
        queue.offer(s) ;
        while(!queue.isEmpty()){
            String input = queue.poll() ;
            if(isValidParentheses(input)){
                ans.add(input);
            //    System.out.println(input);
                proceedtill =true ;
            }
            //than only do travese for level
            if(proceedtill==false){
                for(int i=0 ;i<input.length();i++){
                    if(input.charAt(i)==')' || input.charAt(i)=='(') {
                        String newInput = input.substring(0, i) + input.substring(i + 1);
                        if(!visited.contains(newInput)) {
                            queue.offer(newInput);
                            visited.add(newInput);
                        }
                    }
                }
            }
        }
        return Arrays.asList(ans.toArray(new String[ans.size()])) ;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses invalidParentheses =new RemoveInvalidParentheses();
        String input = "()((((((()l(" ;
        List<String> ans = invalidParentheses.removeInvalidParentheses(input);
        for(String s:ans)
            System.out.println(s);

    }




}
