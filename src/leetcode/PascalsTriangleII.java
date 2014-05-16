package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/6.
 */
public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int numRows) {
        numRows++;

        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(numRows < 1) return temp;
        temp.add(1);
        for(int i = 2; i <= numRows; i++){
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            temp2.add(1);
            for (int j = 0; j < i - 2; j++) {
                temp2.add(temp.get(j) + temp.get(j + 1));
            }
            temp2.add(1);
            temp = temp2;
        }
        return temp;
    }

    public static void main(String args[]){
        new PascalsTriangleII().getRow(3);
    }
}
