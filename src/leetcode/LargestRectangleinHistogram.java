package leetcode;

/**
 * Created by Anthony on 2014/6/9.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];

        left[0] = 0;
        for(int i = 1; i < height.length; i++){
            if(height[i] > height[i-1])
                left[i] = i;
            else{
                int k = i-1;
                while(k > 0){
                    if(height[k] > height[i]){
                        k--;
                    }
                    else if(height[k] == height[i]){
                        k = left[k]-1;
                        break;
                    }
                    else{
                        break;
                    }
                }
                left[i] = k+1;
            }
        }
        right[height.length-1] = height.length-1;
        for(int i = height.length-2; i >= 0; i--){
            if(height[i] > height[i+1])
                right[i] = i;
            else{
                int k = i+1;
                while(k < height.length){
                    if(height[k] > height[i]){
                        k++;
                    }
                    else if(height[k] == height[i]){
                        k = right[k]+1;
                        break;
                    }
                    else {
                        break;
                    }
                }
                right[i] = k-1;
            }
        }

        int max = 0;
        for(int i = 0; i < height.length; i++){
            int m2 = (right[i]-left[i]+1)*height[i];
            if(max < m2) max = m2;
        }
        return max;
    }

    public int largestRectangleArea_tle(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int max = height[0];
        int start = 0, end = 0;
        while(end < height.length){
            while(end < height.length && height[end] >= height[start])
                end++;
            int m2 = height[start] * (end-start);
            if(max < m2) max = m2;
            start++;
            end = start;
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
