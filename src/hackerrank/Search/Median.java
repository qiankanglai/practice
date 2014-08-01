package hackerrank.Search;

import library.AVLTree;

import java.util.Scanner;

/**
 * Created by anthony on 7/16/14.
 */
public class Median {
    public static void main(String[] args) {
        //C++里的multiset用的是红黑树
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();

        AVLTree<Integer> left = new AVLTree<Integer>(), right = new AVLTree<Integer>();
        long left_max = 0, right_min = 0;
        int left_count = 0, right_count = 0;
        for (int _t = 0; _t < t; _t++) {
            String l = in.nextLine();
            int n = Integer.parseInt(l.substring(2).trim());
            if(l.charAt(0) == 'a'){
                if(left_count == 0){
                    left_count++;
                    left.add(n);
                    left_max = n;
                }
                else{
                    if(n < left_max){
                        left.add(n);
                        left_count++;
                    }
                    else{
                        right.add(n);
                        right_count++;
                        if(right_count == 1 || n < right_min){
                            right_min = n;
                        }
                    }
                }
            }
            else if(l.charAt(0) == 'r'){
                if(left_count > 0 && left_max >= n && left.contains(n)){
                    left.remove(n);
                    left_count--;
                    if(left_count > 0 && n == left_max)
                        left_max = left.getGreatest();
                }
                else if(right_count > 0 && right_min <= n && right.contains(n)){
                    right.remove(n);
                    right_count--;
                    if(right_count > 0 && n == right_min)
                        right_min = right.getLeast();
                }
                else{
                    System.out.println("Wrong!");
                    continue;
                }
            }
            else{
                System.out.println("Wrong!");
                continue;
            }
            if(left_count < right_count){
                left.add((int) right_min);
                right.remove((int) right_min);
                left_count++;
                right_count--;
                left_max = right_min;
                if(right_count > 0)
                  right_min = right.getLeast();
            }
            else if(left_count > right_count+1){
                right.add((int) left_max);
                left.remove((int) left_max);
                left_count--;
                right_count++;
                right_min = left_max;
                if(left_count > 0)
                 left_max = left.getGreatest();
            }
            if(left_count == 0){
                System.out.println("Wrong!");
                continue;
            }
            if(left_count == right_count){
                long temp = left_max+right_min;
                if(temp==-1)
                    System.out.print('-');  //build "-1"
                System.out.print(temp/2);
                if(temp % 2 != 0)
                    System.out.print(".5");
                System.out.println();
            }
            else{
                System.out.println(left_max);
            }
        }
    }
}
