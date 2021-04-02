package facebook;

import java.util.Stack;

public class MinStackImpl {
}



class MinStack {

    class Pair{
        int currentValue ;
        int minValue ;
        Pair(int currentValue,int minValue){
            this.currentValue = currentValue ;
            this.minValue =minValue ;
        }
    }

    Stack<Pair> stack = new Stack<Pair>() ;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(stack.isEmpty()){
            Pair pair = new Pair(x,x) ;
            stack.push(pair) ;
        }else{
            Pair top = stack.peek() ;
            if(top.minValue<x){
                stack.push(new Pair(x,top.minValue)) ;
            }else{
                Pair pair = new Pair(x,x) ;
                stack.push(pair) ;
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty())
            stack.pop() ;
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek().currentValue ;
        }else{
            return -100001 ;
        }
    }

    public int getMin() {
        if(!stack.isEmpty()){
            return stack.peek().minValue ;
        }else{
            return -100001 ;
        }
    }
}
