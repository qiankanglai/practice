package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anthony on 2014/5/27.
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> mapping = new HashMap<Integer, String>();
        mapping.put(2, "abc");
        mapping.put(3, "def");
        mapping.put(4, "ghi");
        mapping.put(5, "jkl");
        mapping.put(6, "mno");
        mapping.put(7, "pqrs");
        mapping.put(8, "tuv");
        mapping.put(9, "wxyz");

        ArrayList<String> result = new ArrayList<String>();
        int []d = new int[digits.length()];
        for(int i = 0; i < digits.length(); i++)
            d[i] = digits.charAt(i)-'0';

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(-1);
        while(!stack.empty()){
            if(stack.size() > d.length){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < d.length; i++)
                    sb.append(mapping.get(d[i]).charAt(stack.get(i)));
                result.add(sb.toString());
                stack.pop();
            }
            else{
                int t = stack.pop()+1;
                if(t < mapping.get(d[stack.size()]).length()){
                    stack.push(t);
                    stack.push(-1);
                }
            }
        }

        return result;
    }

    public static void main(String args[]){
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }
}
