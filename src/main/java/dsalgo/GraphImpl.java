package dsalgo;

import java.util.*;

public class GraphImpl {

    public static void main(String[] args) {
        int n = 5;
        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(n);

        for(int i=0;i<n;i++){
            graph.add(null);
        }

        ArrayList<Integer> adjList = new ArrayList<Integer>();

        adjList.add(2);
        adjList.add(1);

        graph.add(3, adjList);

        ArrayList<Integer> adjList1 = new ArrayList<Integer>();
        adjList1.add(3);

        graph.add(0, adjList1);

        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            for (int j=0; graph.get(i)!=null && j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }


}
