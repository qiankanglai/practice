package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anthony on 2014/6/5.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null)
            return result;
        Arrays.sort(candidates);
        int status[] = new int[candidates.length];
        Arrays.fill(status, -1);
        int ptr = 0;
        int value = target;
        while(ptr >= 0){
            status[ptr]++;
            if(status[ptr] > 0)
                value -= candidates[ptr];
            if(value < 0){
                value += status[ptr]*candidates[ptr];
                status[ptr] = -1;
                ptr--;
            }
            else
                ptr++;

            if(value == 0){
                ArrayList<Integer> r = new ArrayList<Integer>();
                for(int i = 0; i < ptr; i++)
                    if(status[i] > 0) {
                        for(int k = 0; k < status[i]; k++)
                            r.add(candidates[i]);
                    }
                result.add(r);

                ptr--;
            }
            else if (ptr >= candidates.length || (ptr >= 0 && value < candidates[ptr])){
                ptr--;
            }
        }

        return result;
    }

    public static void main(String args[]){
        new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
        new CombinationSum().combinationSum(new int[]{2}, 1);
    }
}
