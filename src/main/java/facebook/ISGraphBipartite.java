package facebook;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ISGraphBipartite {
    Map<Integer,Integer> colours = new HashMap<Integer,Integer>() ;
    Queue<Integer> queue = new ArrayDeque<Integer>() ;
    boolean componentBipartitle(int[][] graph,int start){

        queue.add(start) ;
        colours.put(start,1) ;
        int nodes = graph.length ;
        int cnt = 1 ;
        while (!queue.isEmpty()){

            int x = queue.poll() ;
            int currentColour = colours.get(x) ;
            for(int i=0;i<graph[x].length;i++){
                if(colours.containsKey(graph[x][i])){
                    if(currentColour==colours.get(graph[x][i]))
                        return false ;
                }else{
                    queue.add(graph[x][i]) ;
                    cnt++ ;
                    if(currentColour==1){
                        colours.put(graph[x][i],2) ;
                    }else{
                        colours.put(graph[x][i],1) ;
                    }
                }
            }

        }
        return true ;

    }


    public boolean isBipartite(int[][] graph) {
        boolean ans = true ;
        for(int i=0;i<graph.length;i++){
            if(!colours.containsKey(i)){
                ans = ans && componentBipartitle(graph,i) ;
            }
        }

        return ans ;

    }
}
