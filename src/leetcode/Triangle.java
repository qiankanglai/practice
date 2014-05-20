package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/20.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int levels = triangle.size();
        int temp[] = new int[levels], temp2[] = new int[levels];
        for(int i = 0; i < levels; i++)
            temp[i] = triangle.get(levels-1).get(i);
        for(int i = levels-2; i>=0; i--){
            for(int j = 0; j <= i; j++)
                temp2[j] = triangle.get(i).get(j) + Math.min(temp[j], temp[j+1]);
            int[] temp3 = temp;
            temp = temp2;
            temp2 = temp3;
        }
        return temp[0];
    }
    public static void main(String argsp[]){
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> t = new ArrayList<Integer>();
        t.add(1);
        triangle.add(t);
        t = new ArrayList<Integer>();
        t.add(2);t.add(3);
        triangle.add(t);
        new Triangle().minimumTotal(triangle);
    }
}
