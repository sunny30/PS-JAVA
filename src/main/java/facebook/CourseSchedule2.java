package facebook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numCourses) ;
       int[] indegree = new int[numCourses] ;
        int[] ans = new int[numCourses] ;
        int anscnt = 0 ;
        for(int i=0;i<numCourses;i++){
            indegree[i] = 0 ;
            ans[i] = -1 ;
            graph.set(i,new ArrayList<Integer>());
        }
        int rel = prerequisites.length ;
        for(int i=0;i<rel;i++){
            int c1 = prerequisites[i][0] ;
            int c2 = prerequisites[i][1] ;
            graph.get(c2).add(c1) ;
            indegree[c1]++ ;
        }
        Queue<Integer> queue = new ArrayDeque<Integer>()  ;

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.add(i) ;
        }

        while (!queue.isEmpty()){
            int c = queue.poll();
            ans[anscnt++] =c ;
            for(int i=0;i<graph.get(c).size();i++){
                indegree[graph.get(c).get(i)]-- ;
                if(indegree[graph.get(c).get(i)]==0)
                    queue.add(indegree[graph.get(c).get(i)]) ;
            }
        }
        if(anscnt==numCourses)
            return ans ;
        else
            return new int[0] ;
    }
}
