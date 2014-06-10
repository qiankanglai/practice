package leetcode;

import java.util.Stack;

/**
 * Created by Anthony on 2014/6/9.
 */
public class LargestRectangleinHistogram {
    //http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    //用栈来保存！只要维护若干个比较小的bar的位置就行了，比栈顶的元素都不用维护的~用不着
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; i++){
            while(!stack.empty()){
                if(height[stack.peek()] >= height[i])
                    stack.pop();
                else
                    break;
            }
            if(stack.empty())
                left[i] = 0;
            else
                left[i] = stack.peek()+1;
            stack.add(i);
        }

        stack = new Stack<Integer>();
        for(int i = height.length-1; i >= 0; i--){
            while(!stack.empty()){
                if(height[stack.peek()] >= height[i])
                    stack.pop();
                else
                    break;
            }
            if(stack.empty())
                right[i] = height.length-1;
            else
                right[i] = stack.peek()-1;
            stack.add(i);
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
        //System.out.println(new LargestRectangleinHistogram().largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(new int[]{1,1}));
    }
}
