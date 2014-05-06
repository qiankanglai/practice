package leetcode;

import java.util.Stack;

/**
 * Created by anthony on 5/6/14.
 */
public class EvaluateReversePolishNotation {
    //http://oj.leetcode.com/discuss/2410/test-case-failing
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
