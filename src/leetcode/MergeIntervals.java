package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by anthony on 6/8/14.
 */
public class MergeIntervals {
    class IntervalCompare implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return (o1.start - o2.start);
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return res;

        Interval[] _intervals = intervals.toArray(new Interval[]{});
        Arrays.sort(_intervals, new IntervalCompare());

        int count = 0;
        for(int i = 0; i < _intervals.length; i++){
            if(count == 0 || res.get(count-1).end < _intervals[i].start) {
                res.add(_intervals[i]);
                count++;
            }
            else{
                res.get(count-1).end = Math.max(res.get(count-1).end, _intervals[i].end);
            }
        }

        return res;
    }
}
