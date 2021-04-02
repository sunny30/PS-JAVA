package moveworks;

import java.util.Stack;

public class ExpressionParser {


    public boolean isOperator(char op){

        if(op=='+' || op=='-' || op== '/' || op=='*')
            return true ;

        return false ;

    }

    public int findPriority(String op,String[] operator){
        int ans = Integer.MAX_VALUE ;
        for(int i =0 ;i<operator.length;i++){
            if(operator[i].equals(op))
                ans = i ;
        }
        return ans ;

    }

    public Double computeValues(String op1,String op2,String op){

        Double dop1 = Double.parseDouble(op1) ;
        Double dop2 = Double.parseDouble(op2) ;

        if(op.equals("+")){
            return dop1+dop2 ;
        }else if(op.equals("-")){
            return dop2-dop1 ;
        }else if(op.equals("*")){
            return dop1*dop2 ;
        }else if(op.equals("/")){
            return dop2/dop1 ;
        }else{
            return Double.MAX_VALUE ;
        }


    }

    void compute(Stack<String> inp){

        int cnt = 0 ;
        String operator1 = null ;
        String operator2 = null ;
        String operand = null ;
        while(!inp.isEmpty() && cnt<2){
           String peek = inp.pop() ;
           if(peek.length()==1 && isOperator(peek.charAt(0))){
               operand = peek ;

           }else{
               if(cnt==0) {
                   operator1 = peek ;

               }else{
                   operator2 = peek ;
                   //cnt++ ;
               }
               cnt++ ;
           }
        }

        Double result = computeValues(operator1,operator2,operand) ;
        inp.push(result.toString()) ;




    }


    //(1+(1+1+(1+2)))

    public String solution(String s){

        Stack<String> stack = new Stack<String>() ;


        String[] tokens = s.split(" ") ;
        String prevOp = null ;

        String[] operators = {"/","*","+","-"} ;
        for(int i =0;i<tokens.length;i++){

            String val = tokens[i] ;
            if(val.length() == 1 && isOperator(tokens[i].charAt(0))){

                if(prevOp==null)
                    prevOp = val ;
                else{

                    int p1 = findPriority(val,operators) ;
                    int p2 = findPriority(prevOp,operators) ;
                    if(p2<p1){
                        compute(stack);
                    }
                    prevOp = val ;
                }
                stack.push(val) ;
            }else{
                stack.push(val) ;
            }




        }


       while (stack.size()!=1){
           compute(stack);
       }

       return stack.peek() ;



    }


    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser() ;
        System.out.println(parser.solution("2 * 3.1  - 5 / 1")) ;
    }
}
