package google.campustest2015.roundb;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Anthony on 9/15/2014.
 */
public class CardGame {
    // It should be DP!!!
    // Greedy cannot solve this: 5 6 4 5 6 7
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/roundb/C-small-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int N = in.nextInt(), K = in.nextInt();
            Stack<Integer> list = new Stack<Integer>();
            Stack<Integer> list2 = new Stack<Integer>();
            for(int i = 0; i < N; i++){
                list.add(in.nextInt());
            }
            while(list.size() > 2){
                int idx = list.size();
                int v1 = list.get(idx-1), v2 = list.get(idx-2), v3 = list.get(idx-3);
                if(v1 - v2 == K && v2 - v3 == K){
                    list.pop();
                    list.pop();
                    list.pop();
                    if(!list2.empty()){
                        list.push(list2.pop());
                    }
                    if(!list2.empty()){
                        list.push(list2.pop());
                    }
                }
                else{
                    list2.push(list.pop());
                }
            }

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(list.size()+list2.size());
        }
        in.close();
    }
}
