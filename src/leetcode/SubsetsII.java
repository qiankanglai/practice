package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anthony on 2014/6/8.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return result;

        Arrays.sort(num);
        int n[] = new int[num.length+1];
        int c[] = new int[num.length+1];
        int length = 0;
        n[0] = num[0];c[0] = 1;
        for(int i = 1; i < num.length; i++){
            if(num[i] == n[length])
                c[length]++;
            else{
                length++;
                n[length] = num[i];
                c[length] = 1;
            }
        }
        length++;
        c[length] = 1;  //prevent line 54: divided by zero

        int[] flags = new int[length+1];
        Arrays.fill(flags, 0);
        while(flags[length] == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < length; i++)
                if(flags[i] > 0) {
                    for(int p = 0; p < flags[i]; p++)
                        temp.add(n[i]);
                }
            result.add(temp);

            boolean t = true;
            int ptr = 0;
            while(t){
                if(flags[ptr]+1 <= c[ptr]){
                    flags[ptr]+=1;
                    t = false;
                }
                else{
                    t = true;
                    flags[ptr] = 0;
                }
                ptr++;
            }
        }

        return result;
    }

    public static void main(String args[]){
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1,1,2,2}));
    }
}
