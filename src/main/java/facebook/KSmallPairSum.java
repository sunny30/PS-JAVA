package facebook;

import java.util.*;

public class KSmallPairSum {

    class PairS {
        int sum;
        int index1;
        int index2;

        PairS(int sum, int index1, int index2) {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    String getKey(int i, int j) {
        String key = String.valueOf(i) + "," + String.valueOf(j);
        return key;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Set<String> visited = new HashSet<String>();
        PriorityQueue<PairS> pq = new PriorityQueue<PairS>(k, new SortC());
        if (n == 0 || m == 0)
            return ans;
        String key = getKey(0, 0);
        int sum = nums1[0] + nums2[0];
        PairS pairS = new PairS(sum, 0, 0);
        pq.add(pairS);
        int cnt = 0;
        while (cnt <= k && !pq.isEmpty()) {
            PairS p = pq.poll();
            int a = p.index1;
            int b = p.index2;
            List<Integer> tans = new ArrayList<Integer>();
            tans.add(a);
            tans.add(b);
            visited.add(getKey(nums1[a], nums2[b]));
            ans.add(tans);
            cnt++;
            if(cnt==k)
                break;

            int s = a;
            int d = b + 1;
            int s1 = a + 1;
            int d1 = b;

            if (d < m && !visited.contains(getKey(s, d))) {
                int tsum = nums1[s] + nums2[d];
                pq.add(new PairS(tsum, s, d));

            }

            if (s1 < n && !visited.contains(getKey(s1, d1))) {
                int tsum = nums1[s1] + nums2[d1];
                pq.add(new PairS(tsum, s1, d1));

            }


        }

        return ans ;

    }

    class SortC implements Comparator<PairS> {
        public int compare(PairS s1, PairS s2) {
            return s1.sum - s2.sum;
        }
    }
}
