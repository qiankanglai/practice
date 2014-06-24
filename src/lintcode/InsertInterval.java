package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/24.
 */
public class InsertInterval {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        for(int i = 0; i < intervals.size(); i++){
            if(newInterval == null || intervals.get(i).end < newInterval.start)
                result.add(intervals.get(i));
            else{
                if(intervals.get(i).start > newInterval.end){
                    result.add(newInterval);
                    result.add(intervals.get(i));
                    newInterval = null;
                }
                else {
                    newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                    newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                }
            }
        }
        if(newInterval != null){
            result.add(newInterval);
        }
        return result;
    }
}
