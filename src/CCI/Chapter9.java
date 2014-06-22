package CCI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Anthony on 2014/6/20.
 */
public class Chapter9 {
    //9.1
    public int countWays(int s){
        if(s <= 0)
            return 0;
        int steps[] = new int[s+3];
        steps[0] = 1;
        steps[1] = 2;
        steps[2] = 3;
        for(int i = 3; i < s; i++)
            steps[i] = steps[i-1]+steps[i-2]+steps[i-3];
        return steps[s-1];
    }
    //9.2 skipped...组合
    //9.3
    public int magicIndex(int A[], int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(A[mid] == mid)
            return mid;
        else if(A[mid] > mid){
            int t1 = magicIndex(A, start, mid-1);
            if(t1 >= 0)
                return t1;
            //根据答案，不重复版本这个是不必要的~
            int t2 = magicIndex(A, A[mid]+1, end);
            if(t2 >= 0)
                return t2;
        }
        else{
            int t1 = magicIndex(A, mid+1, end);
            if(t1 >= 0)
                return t1;
            int t2 = magicIndex(A, start, A[mid]-1);
            if(t2 >= 0)
                return t2;
        }

        return -1;
    }
    public int magicIndex(int A[]){
        if(A == null || A.length == 0)
            return -1;
        return magicIndex(A, 0, A.length-1);
    }
    //9.4
    public ArrayList<ArrayList<Integer>> getAllSubsets(int A[], int index){
        if(index < 0)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = getAllSubsets(A, index - 1);
        ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> r : res){
            ArrayList<Integer> r2 = new ArrayList<Integer>(r);
            r2.add(A[index]);
            res2.add(r2);
        }
        res2.addAll(res);
        return res2;
    }
    public ArrayList<ArrayList<Integer>> getAllSubsets(int A[]){
        if(A == null || A.length == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        return getAllSubsets(A, A.length-1);
    }
    //9.5 其实可以生成全排列再做的
    public ArrayList<String> getPerms(String str){
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() == 0){
            res.add("");
            return res;
        }
        char c = str.charAt(0);
        ArrayList<String> res_prev = getPerms(str.substring(1));
        for(String s : res_prev){
            int l = s.length();
            for(int i = 0; i <= l; i++){
                String s2 = s.substring(0, i)+c;
                if(i < l)
                    s2 += s.substring(i);
                res.add(s2);
            }
        }
        return res;
    }
    //9.6: 之前做的方法需要判重。这个相对简单点
    public void generateParentness(String current, ArrayList<String> result, int left, int right){
        if(left == 0 && right == 0){
            result.add(current);
            return;
        }
        if(left > 0){
            generateParentness(current+'(', result, left-1, right);
        }
        if(right > left && right > 0){
            generateParentness(current+')', result, left, right-1);
        }
    }
    public ArrayList<String> generateParentness(int n){
        ArrayList<String> temp = new ArrayList<String>();
        if(n <= 0)
            return temp;
        generateParentness("", temp, n, n);
        return temp;
    }

    //9.7
    class Point{
        public int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void paintFill(Color[][] screen, int x, int y, Color color){
        java.util.Stack<Point> stack = new java.util.Stack<Point>();
        stack.push(new Point(x, y));
        Color old = screen[x][y];
        final int[] dx = {-1,0,1,0};
        final int[] dy = {0,-1,0,1};
        while(!stack.empty()){
            Point p = stack.pop();
            screen[p.x][p.y] = color;
            for(int i = 0; i < 4; i++){
                int x2 = p.x+dx[i], y2 = p.y + dy[i];
                if(x2 >= 0 && x2 < screen.length && y2 >= 0 && y2 < screen[0].length && screen[x2][y2] == old)
                    stack.push(new Point(x2, y2));
            }
        }
    }
    //9.8 直接f(n)=f(n-1)+f(n-5)+f(n-10)+f(n-25)有重复计算的
    public int makeChange(int x, int current){
        int nextCurrent = 0;
        switch (current){
            case 25:
                nextCurrent = 10;
                break;
            case 10:
                nextCurrent = 5;
                break;
            case 5:
                nextCurrent = 1;
                break;
            default:
                return 1;
        }
        int sum = 0;
        while(x >= 0){
            sum += makeChange(x, nextCurrent);
            x -= current;
        }
        return sum;
    }
    public int makeChange(int x){
        if(x < 0)
            return 0;
        return makeChange(x, 100);
    }
    //9.9
    public void eightQuenes(int queue[], int index){
        if(index == 8){
            for(int i = 0; i < 8; i++) {
                System.out.print(queue[i]);
                System.out.print(',');
            }
            System.out.println();
            return;
        }
        for(int k = 0; k < 8; k++){
            queue[index] = k;
            boolean flag = false;
            for(int i = 0; i < index; i++){
                if((queue[i] == queue[index]) || (queue[i]-queue[index]==i-index) || (queue[i]-queue[index]==index-i)){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                eightQuenes(queue, index + 1);
        }
    }
    public void eightQuenes(){
        int queue[] = new int[8];
        eightQuenes(queue, 0);
    }

    //9.10 答案是强行dfs+存结果；我用的是拓扑图
    class Box{
        public int height, width, depth;
        public boolean canPutAbove(Box b){
            return (this.height >= b.height && this.width >= b.width && this.depth >= b.depth);
        }
    }
    public int maxDepth(Box[] box){
        ArrayList<Integer>[] prev = new ArrayList[box.length];
        LinkedList<Integer> cache = new LinkedList<Integer>();
        int depth[] = new int[box.length];
        Arrays.fill(depth, 0);
        for(int i = 0; i < box.length; i++){
            prev[i] = new ArrayList<Integer>();
            for(int j = 0; j < box.length; j++){
                if(box[i].canPutAbove(box[j])){
                    prev[i].add(j);
                }
            }
            if(prev[i].size() == 0)
                cache.add(i);
        }
        while(cache.size() > 0){
            int i = cache.removeFirst();
            int m = 0;
            for(Integer j : prev[i]){
                if(depth[j]+1 > m)
                    m = depth[j]+1;
            }
            depth[i] = m;
            for(int j = 0; j < box.length; j++){
                if(prev[j].contains(i)){
                    prev[j].remove(i);
                    if(prev[i].size() == 0){
                        cache.add(j);
                    }
                }
            }
        }

        int m = depth[0];
        for(int i = 1; i < box.length; i++){
            if(m < depth[i])
                m = depth[i];
        }
        return m;
    }
    //9.11
    public int fractial(int n){
        int s = 1;
        for(int i = 2; i <= n; i++)
            s *= i;
        return s;
    }
    public int f(String exp, boolean result){
        int sum = 0;
        if(exp.length() == 1){
            if(exp.charAt(0) == '1' && result)
                return 1;
            else if(exp.charAt(0) == '0' && !result)
                return 1;
            else
                return 0;
        }
        for(int i = 1; i < exp.length(); i+=2){
            char operator = exp.charAt(i);
            String left = exp.substring(0, i);
            String right = exp.substring(i+1);
            switch (operator){
                case '&':
                    if(result) {
                        sum += f(left, true) * f(right, true);
                    }
                    else{
                        sum += fractial(left.length()/2)*fractial(right.length()/2) -  f(left, true) * f(right, true);
                    }
                    break;
                case '|':
                    if(result) {
                        sum += fractial(left.length()/2)*fractial(right.length()/2) -  f(left, false) * f(right, false);
                    }
                    else{
                        sum += f(left, false) * f(right, false);
                    }
                    break;
                case '^':
                    if(result){
                        sum += f(left, false) * f(right, true) + f(left, true) * f(right, false);
                    }
                    else {
                        sum += f(left, true) * f(right, true) + f(left, false) * f(right, false);
                    }
                    break;
            }
        }
        return sum;
    }
    public static void main(String args[]){
        System.out.println(new Chapter9().f("1^0|0|1", false));
        //new Chapter9().eightQuenes();
    }
}
