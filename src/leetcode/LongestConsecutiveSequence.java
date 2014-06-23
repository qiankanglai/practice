package leetcode;

import library.Sort;

/**
 * Created by Anthony on 2014/6/8.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0)
            return 0;
        Sort.RadixSort(num);
        int max = 1;
        int count = 1;
        for(int i = 1; i < num.length; i++){
            if(num[i] == num[i-1]+1){
                count ++;
                if(count > max)
                    max = count;
            }
            else if(num[i] != num[i-1])
                count = 1;
        }
        return max;
    }

    public static void main(String args[]){
        //System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
}
