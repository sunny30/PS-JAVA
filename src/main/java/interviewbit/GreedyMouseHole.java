package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyMouseHole {

    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        Collections.sort(mice); Collections.sort(holes);
        int ans = 0 ;
        for(int i=0;i<mice.size();i++){
            ans =  Math.max(Math.abs(mice.get(i)-holes.get(i)),ans) ;
        }
        return ans ;
    }
}
