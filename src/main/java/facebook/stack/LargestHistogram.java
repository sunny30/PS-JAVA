package facebook.stack;

import java.util.Stack;

public class LargestHistogram {

    class HX{
        int h;
        int x ;
        int to ;
        HX(int h,int x,int to){
            this.h =h ;
            this.x = x ;
            this.to = to ;

        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<HX> stack = new Stack<HX>() ;
        int ans = 0 ;
        stack.push(new HX(heights[0],0,0)) ;

        for(int i=1;i<heights.length;i++){
            if(stack.isEmpty() || heights[i]>stack.peek().h){
                stack.push(new HX(heights[i],i,i)) ;
            }else{
                HX prev =null ;
                HX lastpop = null ;
                while (!stack.isEmpty() && stack.peek().h>=heights[i]){
                    HX current = stack.pop() ;
                    ans = Math.max(ans,current.h*(Math.abs(current.x-current.to)+1)) ;
                    if(prev!=null){
                        int tans = current.h* (Math.abs(current.to-prev.x)+1) ;
                        ans = Math.max(ans,tans) ;
                    }else {
                        prev =current ;
                    }
                    lastpop = current ;
                }
                stack.push(new HX(heights[i],i,lastpop.to) );

            }
        }

        HX prev =null ;
        while (!stack.isEmpty()){
            HX current = stack.pop() ;
            ans = Math.max(ans,current.h*(Math.abs(current.x-current.to)+1)) ;
            if(prev!=null){
                int tans = current.h* (Math.abs(current.to-prev.x)+1) ;
                ans = Math.max(ans,tans) ;
            }else {
                prev =current ;
            }
        }

        return ans ;


    }


    public static void main(String[] args) {
        LargestHistogram largestHistogram = new LargestHistogram() ;
        int[] heights = {1,2,2,4} ;

        System.out.println(largestHistogram.largestRectangleArea(heights));
    }
}
