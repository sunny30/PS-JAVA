package facebook.toplogicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<List<Integer>>() ;
        int[] indegree = new int[numCourses] ;
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
            indegree[i] = 0 ;
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0] ;
            int b = prerequisites[i][1] ;

            graph.get(b).add(a);
            indegree[a]++ ;
        }
        int coursetaken = 0 ;
        Queue<Integer> queue = new ArrayDeque<Integer>() ;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) {
                queue.add(i);
                coursetaken++;
            }
        }

        while (!queue.isEmpty()){

            int x = queue.poll() ;
            for(int i=0;i<graph.get(x).size();i++){
                indegree[graph.get(x).get(i)]-- ;
                if(indegree[graph.get(x).get(i)]==0){
                    queue.add(graph.get(x).get(i)) ;
                    coursetaken++ ;
                }
            }

        }
        return coursetaken==numCourses ;

    }

    public static void main(String[] args) {
        int n = 5 ;
        int relation[][] = {{1,4},{2,4},{3,1},{3,2}} ;

        CourseSchedule schedule = new CourseSchedule() ;
        System.out.println(schedule.canFinish(n,relation)) ;
    }
}
