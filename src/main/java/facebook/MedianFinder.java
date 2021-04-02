package facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> firstq = new PriorityQueue<Integer>(10,new SortMax()) ;
    PriorityQueue<Integer> laterq = new PriorityQueue<Integer>() ;
    Integer counter = 0 ;
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(counter%2==0){
            if(counter==0)
                firstq.add(num) ;
            else if(num> firstq.peek()) {
                laterq.add(num);
                firstq.add(laterq.poll()) ;
            }
            else{
                firstq.add(num) ;
            }
        }else{
            if(num<= firstq.peek()) {
                firstq.add(num);
                laterq.add(firstq.poll()) ;
            }
            else{
                laterq.add(num) ;
                firstq.add(firstq.poll()) ;
            }
        }
        counter++ ;
    }

    public double findMedian() {
        if(counter!=0 && counter%2==0){
            return (Double.parseDouble(laterq.peek().toString())+Double.parseDouble(firstq.peek().toString()))/2 ;
        }{
            return Double.parseDouble(firstq.peek().toString()) ;
        }
    }

    class SortMax implements Comparator<Integer>{
        public int compare(Integer a,Integer b){
            return b-a ;
        }
    }
}
