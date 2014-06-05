package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anthony on 2014/6/5.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null)
            return result;
        Arrays.sort(num);
        int status[] = new int[num.length];
        Arrays.fill(status, -1);
        int ptr = 0;
        int value = target;
        while(ptr >= 0){
            status[ptr]++;
            if(status[ptr] > 0)
                value -= num[ptr];
            if(value < 0 || status[ptr] >= 2){
                value += status[ptr]*num[ptr];
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
                            r.add(num[i]);
                    }
                boolean duplicate = false;
                for(List<Integer> list : result){
                    if(list.size() != r.size())
                        continue;
                    int i = 0, size = r.size();
                    for(; i < size; i++)
                        if(list.get(i) != r.get(i))
                            break;
                    if(i >= size){
                        duplicate = true;
                        break;
                    }
                }
                if(!duplicate)
                    result.add(r);

                ptr--;
            }
            else if (ptr >= num.length || (ptr >= 0 && value < num[ptr])){
                ptr--;
            }
        }

        return result;
    }

    public static void main(String args[]){
        new CombinationSumII().combinationSum2(new int[]{2,3,6,7}, 7);
        new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
