package google.foobar;

/**
 When it rains it pours
 ======================

 It's raining, it's pouring. You and your agents are nearing the building where the captive rabbits are being held, but a sudden storm puts your escape plans at risk. The structural integrity of the rabbit hutches you've built to house the fugitive rabbits is at risk because they can buckle when wet. Before the rabbits can be rescued from Professor Boolean's lab, you must compute how much standing water has accumulated on the rabbit hutches.

 Specifically, suppose there is a line of hutches, stacked to various heights and water is poured from the top (and allowed to run off the sides). We'll assume all the hutches are square, have side length 1, and for the purposes of this problem we'll pretend that the hutch arrangement is two-dimensional.

 For example, suppose the heights of the stacked hutches are [1,4,2,5,1,2,3] (the hutches are shown below):

 ...X...
 .X.X...
 .X.X..X
 .XXX.XX
 XXXXXXX
 1425123

 When water is poured over the top at all places and allowed to runoff, it will remain trapped at the 'O' locations:

 ...X...
 .XOX...
 .XOXOOX
 .XXXOXX
 XXXXXXX
 1425123

 The amount of water that has accumulated is the number of Os, which, in this instance, is 5.

 Write a function called answer(heights) which, given the heights of the stacked hutches from left-to-right as a list, computes the total area of standing water accumulated when water is poured from the top and allowed to run off the sides.

 The heights array will have at least 1 element and at most 9000 elements. Each element will have a value of at least 1, and at most 100000.

 Languages
 =========

 To provide a Python solution, edit solution.py
 To provide a Java solution, edit solution.java

 Test cases
 ==========

 Inputs:
 (int list) heights = [1, 4, 2, 5, 1, 2, 3]
 Output:
 (int) 5

 Inputs:
 (int list) heights = [1, 2, 3, 2, 1]
 Output:
 (int) 0

 Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
 */
public class solution4 {
    public static int answer(int[] heights){
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int tmp = 0;
        for(int i = 0; i < heights.length; i++)
        {
            left[i] = tmp;
            tmp = Math.max(heights[i], tmp);
        }
        tmp = 0;
        for(int i = heights.length-1;i>=0;i--)
        {
            right[i] = tmp;
            tmp = Math.max(heights[i], tmp);
        }
        int sum = 0;
        for(int i = 0; i < heights.length; i++)
        {
            tmp = Math.min(left[i], right[i]);
            sum += Math.max(tmp-heights[i], 0);
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(answer(new int[]{1,4,2,5,1,2,3}));
        System.out.println(answer(new int[]{1,2,3,2,1}));
    }
}
