package toptal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstRound {


    public static String dfs(char i,char[] parent,String sol){
        if(parent[i]=='a') {
            sol = sol+i ;
            return sol;
        }
        sol+=i ;
        return dfs(parent[i],parent,sol)  ;

    }

    public static String findWord(List<String> input){

        int[] indegree = new int[128] ;
        char[] parent = new char[128] ;

        for(int i=0;i<128;i++) {
            indegree[i] = -1;
            parent[i] ='a';
        }
        for(int i=0;i<input.size();i++){

            String s = input.get(i) ;
            String[] tokens = s.split(">") ;
            //indegree[tokens[0].charAt(0)] = 0 ;
            //indegree[tokens[1].charAt(0)] = 0 ;
            parent[tokens[0].charAt(0)] = tokens[1].charAt(0) ;
            indegree[tokens[1].charAt(0)]++ ;
        }

        String ans = "" ;
        for(int i=0;i<128;i++){
            if(parent[i]!='a' && indegree[i]==-1){
                char a = (char)i ;

              //  ans+=a ;
                ans = dfs((char)i,parent,ans) ;

            }
        }

        return ans ;



    }


    public static void main(String[] args) {

        List<String> in = new ArrayList<String>() ;
        String[] a = {"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"};

        in = Arrays.asList(a) ;

        System.out.println(findWord(in));

    }
}
