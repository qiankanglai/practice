package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 2014/6/9.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return result;

        char[] c = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            boolean flag = true;
            for(int j = 0; 2*j <= i; j++){
                if(c[j] != c[i-j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                List<List<String>> r2 = partition(s.substring(i+1));
                String s2 = s.substring(0, i+1);
                if(r2.size() == 0){
                    List<String> tmp = new ArrayList<String>();
                    tmp.add(s2);
                    result.add(tmp);
                }
                else {
                    for (List<String> l : r2) {
                        l.add(0, s2);
                    }
                    result.addAll(r2);
                }
            }
        }

        return result;
    }

    public static void main(String args[]){
        new PalindromePartitioning().partition("aab");
    }
}
