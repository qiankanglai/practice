package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anthony on 2014/6/8.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0)
            return result;
        Arrays.sort(S);

        int length = S.length;
        boolean[] flags = new boolean[length+1];
        Arrays.fill(flags, false);
        while(!flags[length]){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < length; i++)
                if(flags[i])
                    temp.add(S[i]);
            result.add(temp);

            boolean t = true;
            int ptr = 0;
            while(t){
                if(flags[ptr]){
                    flags[ptr] = false;
                    t = true;
                }
                else{
                    flags[ptr] = true;
                    t = false;
                }
                ptr++;
            }
        }
        return result;
    }
}
