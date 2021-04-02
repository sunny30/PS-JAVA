package facebook.toplogicalsort;

import java.util.*;

public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org.length==1 && seqs.size()==0)
            return false ;
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        int[] indegree = new int[org.length + 1];
        Map<Integer,Integer> ans = new HashMap<Integer, Integer>() ;
        int countDiscovered = 0;

        for (int i = 0; i <= org.length; i++) {
            indegree[i] = 0;
            graph.add(new HashSet<Integer>());
        }

        for (List<Integer> seq : seqs) {
            for (int i = 1; i < seq.size(); i++) {
                int a = seq.get(i - 1);
                int b = seq.get(i);

                if(b==a || b>org.length || b<0 || a<0)
                    return false ;

                if (!graph.get(a).contains(b)) {
                    graph.get(a).add(b);
                    indegree[b]++;
                }
            }
            if(seq.size()==1 && (seq.get(0)>org.length || seq.get(0)<0))
                return false ;
        }
        Queue<HashMap.SimpleEntry<Integer,Integer>> queue = new ArrayDeque<HashMap.SimpleEntry<Integer,Integer>>(org.length+1);
        for (int i = 1; i <= org.length; i++) {
            if (indegree[i] == 0) {
                queue.add(new HashMap.SimpleEntry<Integer,Integer>(i,1));
                countDiscovered++;
                // ans.put(i,1) ;
            }


        }
        int level = 1 ;
        while (!queue.isEmpty()){
            HashMap.SimpleEntry<Integer,Integer> v =  queue.poll() ;

            int v1 = v.getKey() ;
            int l1 = v.getValue() ;
            ans.put(v1,l1) ;
            for(int key : graph.get(v1)){
                indegree[key]-- ;
                if(indegree[key]==0){
                    countDiscovered++ ;
                    queue.add(new HashMap.SimpleEntry<Integer,Integer>(key,l1+1));

                }
            }


        }
        System.out.print(countDiscovered) ;
        if(countDiscovered!=org.length)
            return false ;
        for(int i=0 ;i<org.length;i++){
            if(ans.get(org[i])!=i+1)
                return false ;
        }
        return true ;
    }

    public static void main(String[] args) {

    }
}
