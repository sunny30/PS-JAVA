package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flat = new ArrayList<Interval>() ;
        List<Interval> ans = new ArrayList<Interval>() ;
        for(int i=0;i<schedule.size();i++){
            for(int j=0;j<schedule.get(i).size();j++){

                flat.add(schedule.get(i).get(j));
            }
        }
        Collections.sort(flat,new SortCriterion());

        int cover = flat.get(0).end ;
        for(int i=1;i<flat.size();i++){
            if(flat.get(i).start>cover){
                ans.add(new Interval(cover,flat.get(i).start));
                cover = Math.max(cover,flat.get(i).end) ;
            }else{
                cover = Math.max(cover,flat.get(i).end) ;
            }
        }

        return ans ;
    }

    class SortCriterion implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
}
