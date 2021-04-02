package dsalgo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueImpl {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>() ;
        stack.add(1);stack.add(3);stack.add(2) ;

        while(!stack.empty()){
            System.out.println(stack.peek());
            stack.pop() ;
        }


        Queue<Integer> queue = new ArrayDeque<Integer>() ;
        queue.add(2) ;
        queue.add(1) ;queue.add(3) ;

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.poll() ;
        }


    }
}
