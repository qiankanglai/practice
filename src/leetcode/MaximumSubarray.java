package leetcode;

/**
 * Created by anthony on 5/6/14.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int s[] = new int[A.length+1];
        s[0] = 0;
        for(int i = 0; i < A.length; i++)
            s[i+1] = s[i]+A[i];
        int maxs = s[1], mins = 0;
        for(int i = 1; i <= A.length; i++){
            if(s[i] - mins > maxs)
                maxs = s[i] - mins;
            if(s[i] < mins)
                mins = s[i];
        }
        return maxs;
    }

    public static void main(String[] args){
        int []arr = new int[]{-1};
        MaximumSubarray w = new MaximumSubarray();
        System.out.println(w.maxSubArray(arr));
    }
}
