package lintcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by anthony on 6/25/14.
 */
public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }

        Collections.sort(S);
        int len = S.size();
        boolean flags[] = new boolean[len+1];
        while(!flags[len]){
            ArrayList<Integer> r = new ArrayList<Integer>();
            for(int i = 0; i < len; i++){
                if(flags[i])
                    r.add(S.get(i));
            }
            res.add(r);
            int i = 0;
            while(flags[i]){
                flags[i] = false;
                i++;
            }
            flags[i] = true;
        }
        return res;
    }
}
