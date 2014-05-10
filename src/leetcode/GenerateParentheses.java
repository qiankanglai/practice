package leetcode;

import java.util.ArrayList;

/**
 * Created by anthony on 5/10/14.
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        if(n <= 0){
            return new ArrayList<String>();
        }
        else if(n == 1){
            ArrayList<String> res = new ArrayList<String>();
            res.add("()");
            return res;
        }
        else{
            ArrayList<String> res = new ArrayList<String>();

            ArrayList<String> _res = generateParenthesis(n-1);
            for(String s:_res){
                res.add('('+s+')');
            }
            for(int i = 1; i < n; i++){
                ArrayList<String> _res1 = generateParenthesis(i);
                ArrayList<String> _res2 = generateParenthesis(n-i);
                for(String s1:_res1) {
                    for (String s2 : _res2) {
                        String s = s1+s2;
                        if(res.indexOf(s) < 0)
                            res.add(s);
                    }
                }
            }
            return res;
        }
    }
}
