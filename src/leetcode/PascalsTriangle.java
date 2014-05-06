package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/6.
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows < 1) return res;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        for(int i = 2; i <= numRows; i++){
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            temp2.add(1);
            for (int j = 0; j < i - 2; j++) {
                temp2.add(temp.get(j) + temp.get(j + 1));
            }
            temp2.add(1);
            res.add(temp2);
            temp = temp2;
        }
        return res;
    }

    public static void main(String args[]){
        new PascalsTriangle().generate(4);
    }
}
