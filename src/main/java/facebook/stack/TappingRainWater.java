package facebook.stack;

import java.util.Stack;

public class TappingRainWater {

    class XY {
        int x ;
        int y ;
        XY(int x,int y){
            this.x =x ;
            this.y = y ;
        }
    }
    public int trap(int[] height) {
        Stack<XY> stack = new Stack<XY>() ;
        int ans = 0 ;
        if(height.length==0)
            return 0 ;
        stack.push(new XY(0,height[0])) ;

        for(int i=1;i<height.length;i++){
            if(height[i]<stack.peek().y){
                stack.push(new XY(i,height[i])) ;
            }else{
                boolean prev = false ;
                XY prevXY = null ;
                while (!stack.isEmpty() && stack.peek().y<=height[i]){
                    XY xy = stack.pop() ;
                    if(prev){
                       ans = ans + (Math.min(xy.y,height[i])-prevXY.y)*(i-xy.x-1) ;
                    }else {
                        prev =true ;
                    }
                    prevXY = xy ;
                }
                if(!stack.isEmpty()){
                    XY xy = stack.peek() ;
                    ans = ans + (Math.min(xy.y,height[i])-prevXY.y)*(i-xy.x-1) ;
                }
                stack.push(new XY(i,height[i])) ;

            }
        }

        return ans ;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5} ;
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1} ;
        int[] hh = {3,2,2,2,3} ;

        TappingRainWater tappingRainWater = new TappingRainWater() ;
        System.out.println(tappingRainWater.trap(hh)) ;
    }
}
