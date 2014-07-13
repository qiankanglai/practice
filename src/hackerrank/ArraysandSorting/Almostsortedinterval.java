package hackerrank.ArraysandSorting;

import library.BitIndexTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anthony on 7/9/14.
 */
public class Almostsortedinterval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }

        System.out.println(solve(ar, n));
    }

    //也可以用区间树加速，但是写自平衡二叉树譬如AVL比较麻烦
    private static long solve(int[] ar, int n){
        //BIT树加速
        int[] right_closed_small = new int[n];
        int[] left_closed_big = new int[n];

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.empty() && ar[stack.peek()] >= ar[i]){
                stack.pop();
            }
            if(stack.empty()){
                right_closed_small[i] = n;
            }
            else{
                right_closed_small[i] = stack.peek();
            }
            stack.push(i);
        }
        stack = new Stack<Integer>();
        for(int i = 0; i < n; i++){
            while(!stack.empty() && ar[stack.peek()] <= ar[i]){
                stack.pop();
            }
            if(stack.empty()){
                left_closed_big[i] = -1;
            }
            else{
                left_closed_big[i] = stack.peek();
            }
            stack.push(i);
        }

        ArrayList<Integer> intervals[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            intervals[i] = new ArrayList<Integer>();
        }

        BitIndexTree tree = new BitIndexTree(n+1);
        long count = 0;
        for(int i = n-1; i >= 0; i--){
            //表示i+1作为可用的Right
            tree.update(i+1, 1);
            if(left_closed_big[i] >= 0){
                //删掉不可用的Right
                intervals[left_closed_big[i]].add(i);
            }
            for(Integer j : intervals[i]){
                tree.update(j+1, -1);
            }
            //检查在i到right_closed_small[i]中可用的Right有几个（i自己作为Left）
            count += tree.read(right_closed_small[i]) - tree.read(i);
        }

        return count;
    }

    private static long solve_tle2(int[] ar, int n){
        //线段树依然超时
        int[] right_closed_small = new int[n];

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.empty() && ar[stack.peek()] >= ar[i]){
                stack.pop();
            }
            if(stack.empty()){
                right_closed_small[i] = n;
            }
            else{
                right_closed_small[i] = stack.peek();
            }
            stack.push(i);
        }
        stack = new Stack<Integer>();
        TreeNode2 root = new TreeNode2(0, n-1);
        for(int i = 0; i < n; i++){
            while(!stack.empty() && ar[stack.peek()] <= ar[i]){
                stack.pop();
            }
            root.insert(i, stack.empty()?-1:stack.peek());
            stack.push(i);
        }

        long count = 0;
        for(int i = 0; i < n; i++){
            count++;    //single element
            count += root.count_smaller(i+1, right_closed_small[i], i);
        }

        return count;
    }
    static class TreeNode2{
        int start = 0, end = 0, mid = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        TreeNode2 left = null, right = null;
        public TreeNode2(int s, int e){
            start = s;
            end = e;
            mid = (start+end) / 2;
        }
        public int count_smaller(int start, int end, int value){
            int newstart = Math.max(start, this.start), newend = Math.min(end, this.end);
            if(newstart > newend){
                return 0;
            }
            if(value > max){
                //all elements meet requiremnt
                return (newend-newstart+1);
            }
            if(start == end){
                //leaf
                return (value > max)?1:0;
            }
            else{
                int count = 0;
                if(left != null){
                    count += left.count_smaller(newstart, newend, value);
                }
                if(right != null){
                    count += right.count_smaller(newstart, newend, value);
                }
                return count;
            }
        }
        public void insert(int index, int value){
            if(min > value){
                min = value;
            }
            if(max < value){
                max = value;
            }
            if(start < end){
                if(index <= mid){
                    if(left == null){
                        left = new TreeNode2(start, mid);
                    }
                    left.insert(index, value);
                }
                else{
                    if(right == null){
                        right = new TreeNode2(mid+1, end);
                    }
                    right.insert(index, value);
                }
            }
        }
    }

    private static long solve_tle(int[] ar, int n) {
        int[] next_big = new int[n];
        int[] next_small = new int[n];
        next_big[n-1] = -1;
        next_small[n-1] = -1;
        for(int i = n-2; i >= 0; i--){
            if(ar[i+1] > ar[i]){
                next_big[i] = i+1;
                int k = next_small[i+1];
                while(k >= 0){
                    if(ar[k] < ar[i]){
                        break;
                    }
                    else{
                        k = next_small[k];
                    }
                }
                next_small[i] = k;
            }
            else if(ar[i+1] < ar[i]){
                next_small[i] = i+1;
                int k = next_big[i+1];
                while(k >= 0){
                    if(ar[k] > ar[i]){
                        break;
                    }
                    else{
                        k = next_big[k];
                    }
                }
                next_big[i] = k;
            }
            else{
                next_big[i] = next_big[i+1];
                next_small[i] = next_small[i+1];
            }
        }
        long count = 0;
        for(int i = 0; i < n; i++){
            count++;    //single element
            int end = next_big[i];
            while(end > 0){
                if(next_small[i] < 0 || end < next_small[i]){
                    count++;
                }
                else{
                    break;
                }
                end = next_big[end];
            }
        }
        return count;
    }
}
