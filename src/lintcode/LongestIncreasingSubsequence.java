package lintcode;

/**
 * Created by anthony on 6/28/14.
 */
public class LongestIncreasingSubsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int flags[] = new int[nums.length];
        flags[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            int m = 1;
            for(int j = i-1; j >= 0; j--){
                if(nums[j] <= nums[i] && flags[j]+1 > m){
                    m = flags[j]+1;
                }
            }
            flags[i] = m;
            if(m > max){
                max = m;
            }
        }
        return max;
    }

    public static void main(String args[]){
       System.out.println(new LongestIncreasingSubsequence().longestIncreasingSubsequence(new int[]{1,1,1,1,1,1,1,}));
    }
}
