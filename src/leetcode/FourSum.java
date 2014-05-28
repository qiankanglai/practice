package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anthony on 2014/5/27.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int last_i1_num = 100000;
            for(int i1 = 0; i1 < num.length-3; i1++){
                if(num[i1] == last_i1_num)
                    continue;
                else
                    last_i1_num = num[i1];
                int last_i2_num = 100000;
                for(int i2 = i1+1; i2 < num.length-2; i2++) {
                    if (num[i2] == last_i2_num)
                        continue;
                    else
                        last_i2_num = num[i2];

                    int j = i2+1, k = num.length-1;
                    while(j < k){
                        int sum = num[i1]+num[i2]+num[j]+num[k]-target;
                        if(sum == 0){
                            ArrayList<Integer> sb = new ArrayList<Integer>();
                            sb.add(num[i1]);
                            sb.add(num[i2]);
                            sb.add(num[j]);
                            sb.add(num[k]);
                            result.add(sb);

                            while(j<num.length-1 && num[j]==num[j+1])   //skip the same numbers
                                j++;
                            j++;
                            while(k >i2+1 && num[k]==num[k-1])
                                k--;
                            k--;
                        }
                        else if(sum < 0) {
                            j++;
                        }
                        else {
                            k--;
                        }
                    }
                }
        }
        return result;
    }

    public static void main(String args[]){
        new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
