package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anthony on 6/6/14.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        {
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int t = 0; t < num.length; t++)
                r.add(num[t]);
            res.add(r);
        }

        while(true){
            int i = num.length-2;
            while(i >= 0 && num[i] >= num[i+1])
                i--;
            if(i < 0)
                break;
            int ii = i+1, j = num.length-1;
            while(num[i] >= num[j])
                j--;
            //swap
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            //reverse
            int start = ii, end = num.length-1;
            for(int p = start, pe = (start+end); 2*p < pe; p++){
                temp = num[p];
                num[p] = num[pe-p];
                num[pe-p] = temp;
            }

            ArrayList<Integer> r = new ArrayList<Integer>();
            for(int t = 0; t < num.length; t++)
                r.add(num[t]);
            res.add(r);
        }

        return res;
    }

    public static void main(String args[]){
        System.out.println(new PermutationsII().permuteUnique(new int[]{1,1,2}).size());
    }
}
