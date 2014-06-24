package lintcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by anthony on 6/25/14.
 */
public class SubsetsII {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }

        Collections.sort(S);
        int len = 0;
        int number[] = new int[S.size()+1];
        int count[] = new int[S.size()+1];
        for(int i = 0; i < S.size(); i++){
            if(len > 0 && S.get(i) == number[len-1])
                count[len-1]++;
            else{
                count[len] = 1;
                number[len] = S.get(i);
                len++;
            }
        }

        count[len] = 1;
        int flags[] = new int[len+1];
        while(flags[len] == 0){
            ArrayList<Integer> r = new ArrayList<Integer>();
            for(int i = 0; i < len; i++){
                if(flags[i] > 0) {
                    for(int k = 0; k < flags[i]; k++) {
                        r.add(number[i]);
                    }
                }
            }
            res.add(r);
            int i = 0;
            while(flags[i] == count[i]){
                flags[i] = 0;
                i++;
            }
            flags[i]++;
        }
        return res;
    }
}
