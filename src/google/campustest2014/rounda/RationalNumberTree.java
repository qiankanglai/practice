package google.campustest2014.rounda;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anthony on 8/20/14.
 */
public class RationalNumberTree {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2014/rounda/B-large-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        BigInteger b2 = new BigInteger("2");
        for (int _t = 0; _t < T; _t++) {
            temp = in.nextLine();
            String[] temp2 = temp.split(" ");
            int id = Integer.parseInt(temp2[0]);

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            if(id == 1){
                BigInteger n = new BigInteger(temp2[1]);
                long p = 1, q = 1;
                Stack<Integer> stack = new Stack<Integer>();
                while(n.compareTo(BigInteger.ONE) != 0){
                    stack.add(n.mod(b2).intValue());
                    n = n.divide(b2);
                }
                while(!stack.empty()){
                    if(stack.pop() == 0){
                        q += p;
                    }
                    else{
                        p += q;
                    }
                }

                System.out.print(p);
                System.out.print(' ');
                System.out.println(q);
            }
            else{
                BigInteger p = new BigInteger(temp2[1]);
                BigInteger q = new BigInteger(temp2[2]);
                Stack<Integer> stack = new Stack<Integer>();
                while(p.compareTo(BigInteger.ONE) != 0 || q.compareTo(BigInteger.ONE) != 0){
                    if(p.compareTo(q) > 0){
                        stack.add(1);
                        p = p.subtract(q);
                    }
                    else{
                        stack.add(0);
                        q = q.subtract(p);
                    }
                }
                BigInteger n = new BigInteger("1");
                while(!stack.empty()){
                    n = n.multiply(b2);
                    if(stack.pop() == 1){
                        n = n.add(BigInteger.ONE);
                    }
                }
                System.out.println(n);
            }
        }
        in.close();
    }
}
