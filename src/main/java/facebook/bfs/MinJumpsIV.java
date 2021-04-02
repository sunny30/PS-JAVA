package facebook.bfs;

import java.util.*;

public class MinJumpsIV {

    class PP{
        int index ;
        int dist ;
        PP(int index,int dist){
            this.dist = dist ;
            this.index = index ;
        }
    }

    public int minJumps(int[] arr) {

        Map<Integer, Set<Integer>>  map = new HashMap<Integer, Set<Integer>>() ;
        int[] dp = new int[arr.length] ;

        for(int i = arr.length-1;i>=0;i--){
            if(i==arr.length-1)
                dp[i] = 1 ;
            else{
                if(arr[i]==arr[i+1])
                    dp[i] = dp[i+1]+1 ;
                else
                    dp[i]=1 ;
            }
        }
        int k = 0 ;
       while (k<arr.length){
            if(!map.containsKey(arr[k])){
                Set<Integer> index = new HashSet<Integer>() ;index.add(k) ;
                map.put(arr[k],index) ;
                k = k+dp[k]-1 ;
                map.get(arr[k]).add(k);
                k++ ;
            }else{
                map.get(arr[k]).add(k);
                k = k+dp[k]-1 ;
                map.get(arr[k]).add(k);
                k++ ;

            }
        }

        Queue<PP> queue = new ArrayDeque<PP>() ;
        queue.add(new PP(0,0) ) ;
        boolean[] visited = new boolean[arr.length] ;
        while (!queue.isEmpty()){

            PP p = queue.poll() ;
            int i = p.index ;
            int d = p.dist ;
            visited[i] = true ;
            if(i==arr.length-1)
                return d ;

            if(i+1<arr.length && !visited[i+1]){
                visited[i+1] = true  ;
                queue.add(new PP(i+1,d+1)) ;

            }
            if(i-1>=0 && !visited[i-1]){
                visited[i-1] = true  ;
                queue.add(new PP(i-1,d+1)) ;
            }
            for(int j:map.get(arr[i])){
                int a = j ;
                if(!visited[a] && i!=a)
                    queue.add(new PP(a,d+1)) ;
            }

        }

        return arr.length ;
    }
}
