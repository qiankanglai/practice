package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if(A==null || A.length == 0) return 0;
        int sum = 0;
        int []biggest_from_left = new int[A.length];
        int []biggest_from_right = new int[A.length];
        biggest_from_left[0] = A[0];
        for(int i = 1; i < A.length; i++)
            biggest_from_left[i] = (biggest_from_left[i-1]>A[i])?biggest_from_left[i-1]:A[i];
        biggest_from_right[A.length-1] = A[A.length-1];
        for(int i = A.length-2; i >= 0; i--)
            biggest_from_right[i] = (biggest_from_right[i+1]>A[i])?biggest_from_right[i+1]:A[i];

        for(int i = 1; i < A.length-1; i++){
            int t = Math.min(biggest_from_left[i], biggest_from_right[i]);
            if(t > A[i])
                sum += t-A[i];
        }
        return sum;
    }
    public static void main(String args[]){
        System.out.println(new TrappingRainWater().trap(new int[]{
                0,1,0,2,1,0,1,3,2,1,2,1
        }));
    }
}
