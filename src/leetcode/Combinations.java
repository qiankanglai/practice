package leetcode;

import java.util.ArrayList;

/**
 * Created by anthony on 5/16/14.
 */
public class Combinations {
    ArrayList<ArrayList<Integer>> res = null;
    ArrayList<Integer> temp = new ArrayList<Integer>();
    public void go(int n, int k){
        if(k == 0){
            ArrayList<Integer> t = new ArrayList<Integer>();
            for(int i=0;i<temp.size();i++)
                t.add(temp.get(temp.size()-1-i));
            res.add(t);
            return;
        }
        if(n < 1)
            return;

        go(n-1,k);

        temp.add(n);
        go(n-1,k-1);
        temp.remove(temp.size()-1);
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        res = new ArrayList<ArrayList<Integer>>();
        go(n, k);
        return res;
    }

    public static void main(String args[]){
        new Combinations().combine(1,1);
    }
}
