package facebook;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class JumpGameII {


    public int jump(int[] nums) {
        Queue<HashMap.SimpleEntry<Integer,Integer>> queue = new ArrayDeque<HashMap.SimpleEntry<Integer, Integer>>() ;
        HashMap.SimpleEntry<Integer,Integer> a = new HashMap.SimpleEntry<Integer, Integer>(0,0) ;

        queue.add(a) ;
        int[] dis = new int[nums.length] ;
        for(int i=0;i<nums.length;i++)
            dis[i] = -1 ;
        dis[0] = 0 ;
        while (!queue.isEmpty()){
            HashMap.SimpleEntry<Integer,Integer> b = queue.poll() ;
            int l = b.getValue() ;
            int v = b.getKey() ;
            if(v==nums.length-1)
                return l ;
            for(int i =1 ;i <=nums[v];i++){
                if(v+i<nums.length && dis[v+i]==-1){
                    queue.add(new HashMap.SimpleEntry<Integer,Integer>(v+i,l+1)) ;
                    dis[v+i] = l+1 ;
                }
            }
        }

        return dis[nums.length-1] ;

    }
}
