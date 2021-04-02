package interviewbit.dp;

import java.util.ArrayList;
import java.util.List;

public class Tilling3A {

    public static final Integer MOD = 1000000007;
    List<String> correctPermutation = new ArrayList<String>();
    List<List<Integer>> graph = new ArrayList<List<Integer>>();

    public boolean compatible(int i, int j) {
        String s = correctPermutation.get(i);
        String t = correctPermutation.get(j);

        for (int ii = 0; ii < s.length(); ii++) {
            if (s.charAt(ii) == t.charAt(ii))
                return false;
        }
        return true;
    }

    public void generatePermutation(int pos, int current, String permutation) {

        permutation = permutation + String.valueOf(current);

        if (pos == 3) {
            correctPermutation.add(permutation);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            if (current != i) {
                generatePermutation(pos + 1, i, permutation);
            }
        }
    }

    public int solution(int n) {
        for (int i = 1; i <= 4; i++) {
            generatePermutation(1, i, "");
        }
        for (int i = 0; i < correctPermutation.size(); i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < correctPermutation.size(); i++) {
            for (int j = 0; j < correctPermutation.size(); j++) {
                if (compatible(i, j))
                    graph.get(i).add(j);
            }
        }

        int[][] dp = new int[2][correctPermutation.size()];
        int current = 0;
        int prev = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                for (int j = 0; j < 36; j++)
                    dp[current][j] = 1;
            } else {
                for (int j = 0; j < 36; j++) {
                    dp[current][j] = 0;
                    for (int k = 0; k < graph.get(j).size(); k++) {
                        dp[current][j] = (dp[current][j] + dp[prev][graph.get(j).get(k)]) % MOD;
                    }
                }
            }
            int temp = current;
            current = prev;
            prev = temp;
        }

        int ans = 0;
        for (int i = 0; i < 36; i++) {
            ans = (ans + dp[prev][i]) % MOD;
        }

        return ans;


    }


    public static void main(String[] args) {
        Tilling3A tilling3A = new Tilling3A();

        int ans  = tilling3A.solution(100) ;

        System.out.println(ans);


    }


}
