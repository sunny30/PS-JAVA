package zendrive;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public Integer dfs(List<List<Integer>> adj, int[] ans, int current) {


        int tans = adj.get(current).size();
        int tans1 = 0;
        for (int i = 0; i < adj.get(current).size(); i++) {

            tans1 += dfs(adj, ans, adj.get(current).get(i));
            ans[current] = tans + tans1;

        }

        return ans[current];


    }


    public int[] solve(int n, int[] reportees) {

        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++)
            ans[i] = 0;


        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<Integer>());

        for (int i = 0; i < reportees.length; i++) {
            adj.get(reportees[i]).add(i + 2);
        }

        dfs(adj, ans, 1);
        return ans;


    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] reportees = {1, 1, 2, 3};
        int[] ans = solution2.solve(5, reportees);
        for (int i = 0; i < ans.length; i++)

            System.out.println(ans[i]);

    }
}
