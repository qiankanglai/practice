package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by anthony on 5/29/14.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='('){
                if(i+1 < s.length() && s.charAt(i+1)==')') {
                    temp.add(2);
                    i++;
                }
                else
                    temp.add(-1);
            }
            else
                temp.add(-2);
        }
        boolean flag = false;
        do{
            flag = false;
            for(int i = 0; i < temp.size(); i++){
                if(temp.get(i) >= 0 && i+1 < temp.size() && temp.get(i+1)>=0){
                    temp.set(i, temp.get(i)+temp.get(i+1));
                    temp.remove(i+1);
                    flag = true;
                }
            }
            for(int i = 0; i < temp.size(); i++){
                if(temp.get(i) == -1 && i+2 < temp.size() && temp.get(i+1)>=0 && temp.get(i+2) == -2){
                    temp.set(i, 2+temp.get(i+1));
                    temp.remove(i+1);
                    temp.remove(i+1);
                    flag = true;
                }
            }
        }while(flag);

        int max = 0;
        for(int i = 0; i < temp.size(); i++)
            if(temp.get(i) > max)
                max = temp.get(i);
        return max;
    }

    public static void main(String args[]){
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")(()())"));
    }
}
