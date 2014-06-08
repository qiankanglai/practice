package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 6/8/14.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null){
            intervals = new ArrayList<Interval>();
        }
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }

        int t = intervals.size();
        for(int i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start > newInterval.start){
                t = i;
                break;
            }
        }
        intervals.add(t, newInterval);
        if(t > 0)
            t--;
        while(t+1 < intervals.size()){
            if(intervals.get(t).end >= intervals.get(t+1).start){
                intervals.get(t).end = Math.max(intervals.get(t).end, intervals.get(t+1).end);
                intervals.remove(t+1);
            }
            else
                t++;
        }

        return intervals;
    }
}
