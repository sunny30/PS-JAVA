package leetcodeuber;

import java.util.*;

class Pair{
    String input ;
    Integer frequency ;

    Pair(String input,Integer frequency){
        this.frequency =frequency ;
        this.input = input ;
    }


}

public class TopKElement {

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k,new PairComparator()) ;
        Map<String,Integer> map = new HashMap<String,Integer>();

        for(int i=0;i<words.length;i++){
            String word = words[i] ;
            Integer nFrequency =1 ;
            if(map.containsKey(word)){
                nFrequency = map.get(word)+1 ;
                map.put(word,nFrequency) ;
            }else{
                map.put(word,1) ;
            }

            }

        for(String word:map.keySet()) {
            Integer nFrequency = map.get(word);
            Pair pair = new Pair(word, nFrequency);
            if (pq.size() < k) {
                pq.add(pair);
            } else {
                Pair top = pq.peek();
                if (top.frequency < pair.frequency) {
                    // while(!pq.isEmpty() && pq.peek().input.equalsIgnoreCase(top.input))
                    pq.poll();
                    pq.add(pair);
                }
            }
        }
        List<String> ans = new ArrayList<String>() ;
        while (!pq.isEmpty()){
            ans.add(pq.poll().input) ;
        }
        Collections.reverse(ans);
        return ans ;
    }

    class PairComparator implements Comparator<Pair>{

        public int compare(Pair o1, Pair o2) {
            if(o1.frequency==o2.frequency){
                return o1.input.compareTo(o2.input) ;
            }else{
                return o1.frequency-o2.frequency ;
            }

        }
    }


    public static void main(String[] args) {
        TopKElement kElement = new TopKElement() ;
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"} ;
        List<String> ans = kElement.topKFrequent(words,4) ;
        for(String word:ans){
            System.out.println(word);
        }
    }


}
