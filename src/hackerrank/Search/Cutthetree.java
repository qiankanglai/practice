package hackerrank.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/14/14.
 */
public class Cutthetree {
    static ArrayList<Integer> neighbours[] = null;
    static int weights[] = null, depth[] = null, subtree_weight[] = null;
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        weights = new int[n];
        neighbours = new ArrayList[n];
        int sum_weight = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
            sum_weight += weights[i];
            neighbours[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            a--;
            b--;
            neighbours[a].add(b);
            neighbours[b].add(a);
        }
        depth = new int[n];
        subtree_weight = new int[n];   //以节点i为根的子树权重和
        Arrays.fill(depth, -1);
        subtree_weight[0] = buildtree(0, 0);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int m2 = Math.abs(2*subtree_weight[i]-sum_weight);
            if(m2 < min){
                min = m2;
            }
        }

        System.out.println(min);
    }

    private static int buildtree(int node, int d) {
        int sum = weights[node];
        depth[node] = d;
        for(Integer neighbour : neighbours[node]){
            if(depth[neighbour] < 0) {
                subtree_weight[neighbour] = buildtree(neighbour, d + 1);
                sum += subtree_weight[neighbour];
            }
        }
        return sum;
    }
}
