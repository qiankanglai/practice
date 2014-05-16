package leetcode;

/**
 * Created by Anthony on 2014/5/12.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int l=0, r=height.length-1;
        while(l < r){
            int area = Math.min(height[l], height[r])*(r-l);
            if(max<area) max=area;
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,1}));
    }
}
