package facebook;


import java.util.*;

public class WordBreak {

    class Pair{
        int st ;
        int ed ;
        Pair(int st,int ed){
            this.st = st ;
            this.ed = ed ;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<Integer> set = new HashSet<Integer>() ;
        Queue<Pair> queue = new ArrayDeque<Pair>() ;
        for(int i=0;i<s.length();i++){
            for(String word:wordDict)
                if(stringcmp(s,0,i,word) && !set.contains(i)){
                    queue.add(new Pair(0,i)) ;
                    set.add(i) ;
                }
        }
        boolean ans = false ;
        while (!queue.isEmpty()){

            Pair p = queue.poll() ;
            if(p.ed==s.length()-1){
                ans = true ;
                return true ;
            }
            for(int i = p.ed+1;i<s.length();i++){
                for(String word:wordDict)
                    if(stringcmp(s,p.ed+1,i,word) && !set.contains(i)){
                        queue.add(new Pair(p.ed+1,i)) ;
                        set.add(i) ;
                    }
            }
        }

        return ans ;



    }

    private boolean stringcmp(String superString,int i,int j,String p){
        if(j-i+1!=p.length())
            return false ;
        else{
            for(int l=0;l<p.length();l++){
                if(p.charAt(l)!=superString.charAt(i+l))
                    return false ;
            }
        }
        return true ;
    }
}
