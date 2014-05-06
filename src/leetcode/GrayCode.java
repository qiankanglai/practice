package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/6.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n < 1) {
            res.add(0);
            return res;
        }
        if(n == 1){
            res.add(0);
            res.add(1);
        }
        else{
            ArrayList<Integer> res_old = grayCode(n-1);
            res.addAll(res_old);
            int k = 1<<(n-1);
            for(int i = res_old.size()-1; i >= 0; i--)
                res.add(res.get(i)+k);
        }
        return res;
    }
}
