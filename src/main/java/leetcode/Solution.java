package leetcode;

class Solution {
    public static int maxArea(int[] height) {
        if(height.length<2)
            return 0 ;
        int n = height.length ;
        int last = n-1 ;
        int start = 0 ;
        int ans = 0 ;
        while(start<last){
            ans = Math.max(ans,(last-start)*Math.min(height[start],height[last])) ;
            if(height[start]<height[last])
                start++ ;
            else{
                last--;
            }
        }
        return ans ;
    }


    public static void main(String[] args) {
        int[] height = {10,1,2,3,9,8} ;
        System.out.println(maxArea(height));

    }
}
