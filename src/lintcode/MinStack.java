package lintcode;

import java.util.Stack;

/**
 * Created by anthony on 6/25/14.
 */
public class MinStack {
    private Stack<Integer> numbers = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    public MinStack() {
        // do initialize if necessary
    }

    public void push(int number) {
        // write your code here
        numbers.push(number);
        if(min.empty() || min.peek() >= number){
            min.push(number);
        }
    }

    public int pop() {
        // write your code here
        int n = numbers.pop();
        if(min.peek() == n){
            min.pop();
        }
        return n;
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
