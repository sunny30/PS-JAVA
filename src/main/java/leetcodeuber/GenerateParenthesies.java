package leetcodeuber;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesies {

    List<String> solution = new ArrayList<String>() ;

    public void genparenthisies(String sol,int openCount,int pos,int limit){


        if(pos==limit && openCount==0)
        {
            solution.add(sol);
            return ;
        }else if(pos<limit){
            if(openCount<=limit/2)
                genparenthisies(sol+"(",openCount+1,pos+1,limit) ;
            if(openCount>0)
                genparenthisies(sol+")",openCount-1,pos+1,limit) ;
        }

    }

    public List<String> genparenthisies(int n){
        int pos = 2*n ;
        int openCount = 0 ;
         genparenthisies("",0,0,pos) ;
         return solution ;
    }

    public static void main(String[] args) {
        GenerateParenthesies generateParenthesies = new GenerateParenthesies() ;
        generateParenthesies.genparenthisies(1) ;
        for(String s: generateParenthesies.solution){
            System.out.println(s);
        }
    }
}
