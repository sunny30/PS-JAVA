package toptal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fourth {

    public boolean dfs(List<Set<Integer>> adj, int start, int covered, int limit) {


        covered++;

        if (start == limit && covered == limit)
            return true;

        if(adj.get(start).contains(start+1))
            return dfs(adj, start + 1, covered, limit);
        else
            return false;


    }

    public boolean solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8

        List<Set<Integer>> adj = new ArrayList<Set<Integer>>();

        for (int i = 0; i <= N; i++) {
            adj.add(new HashSet<Integer>());
        }
        for (int i = 0; i < A.length; i++) {
            adj.get(A[i]).add(B[i]);
            adj.get(B[i]).add(A[i]);
        }

        return dfs(adj, 1, 0,N) ;
    }

    public static void main(String[] args) {
        Fourth fourth = new Fourth() ;
        int N =4 ;
        int[] A = {1,2,4,4,3} ;
        int[] B = {2,3,1,3,1} ;

        int[] A1 = {1,2,1,3} ;
        int[] B1 = {2,4,3,4} ;

        int[] A2 = {1,3} ;
        int[] B2 = {2,2} ;
        System.out.println(fourth.solution(3,A2,B2));
    }
}
