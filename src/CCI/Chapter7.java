package CCI;

import library.SmallRootHeap;

import java.util.*;
import java.util.Stack;

/**
 * Created by Anthony on 2014/6/19.
 */
public class Chapter7 {
    //7.1: p>=p^3+3*p^2(1-p), p<=0.5
    //7.2: 1-(1-p)^n-p^n
    //7.3: 见leetcode.MaxPointsonaLine, 不平行或重合
    //7.4 抽象的不漂亮
    public int minus(int a, int b){
        int k1 = (b>0)?-1:1;
        int k2 = (k1>0)?-1:1;
        while(b != 0){
            b += k1;
            a += k2;
        }
        return a;
    }
    public int multiply(int a, int b){
        int k1 = (b>0)?-1:1;
        int k2 = (b>0)?a:minus(0, a);
        int sum = 0;
        while(b != 0){
            b += k1;
            sum += k2;
        }
        return sum;
    }
    public int divide(int a, int b){
        if(b == 0){
            return 0;   //exception
        }
        if(b < 0){
            b = minus(0, b);
            a = minus(0, a);
        }
        int t = 1;
        if(a < 0){
            a = minus(0, a);
            t = -1;
        }
        int r = 0;
        b = minus(0, b);
        while(a >= 0){
            a += b;
            r += t;
        }
        return r;
    }

    //7.5连正方形中心
    //7.6 leetcode.MaxPointsonaLine
    //7.7: 不是最好算法
    public int getKthMagicNumber(int k){
        SmallRootHeap<Integer> stack = new SmallRootHeap<Integer>();
        stack.add(1);
        for(int i = 0; i < k; i++){
            int t = stack.pop();
            //这里有问题，需要检查是否出现过了
            stack.add(t*3);
            stack.add(t*5);
            stack.add(t*7);
        }
        return stack.pop();
    }

}
