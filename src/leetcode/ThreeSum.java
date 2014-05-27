package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Anthony on 2014/5/27.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
            if(i > 0 && num[i]==num[i-1])
                continue;

            int j = i+1, k = num.length-1;
            while(j < k){
                int sum = num[i]+num[j]+num[k];
                if(sum == 0){
                    ArrayList<Integer> sb = new ArrayList<Integer>();
                    sb.add(num[i]);
                    sb.add(num[j]);
                    sb.add(num[k]);
                    result.add(sb);

                    while(j<num.length-1 && num[j]==num[j+1])   //skip the same numbers
                        j++;
                    j++;
                    while(k >i+1 && num[k]==num[k-1])
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
        return result;
    }
    public List<List<Integer>> threeSum0(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length-1; j++){
                int k = -(num[i]+num[j]);
                if(k < num[j] || k > num[num.length-1])
                    continue;
                int low = j+1, high = num.length-1;
                int mid = 0;
                while(low <= high){
                    mid = (low+high)/2;
                    if(num[mid] == k)
                        break;
                    else if(num[mid] < k)
                        low=mid+1;
                    else
                        high = mid-1;
                }
                if(num[mid] != k)
                    continue;

                boolean found = false;
                for(List<Integer> r : result){
                    if(r.get(0)==num[i] && r.get(1)==num[j]){
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    ArrayList<Integer> sb = new ArrayList<Integer>();
                    sb.add(num[i]);
                    sb.add(num[j]);
                    sb.add(k);
                    result.add(sb);
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        //System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,4}).size());
        System.out.println(new ThreeSum().threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}).size());
    }
}
