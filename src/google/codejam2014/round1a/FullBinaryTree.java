package google.codejam2014.round1a;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anthony on 4/26/14.
 */

//赛后参考吴迪的代码，有个细节改对了(当时小数据 AC, 大数据incorrect)

class FullBinaryTree {
    static int N, deleted, currentDeleted;
    static int []depth, children_all;
    static ArrayList<ArrayList<Integer>> map;

    static boolean build(int node, int d){
        if(depth[node] >= 0)
            return false;

        depth[node] = d;
        int c_all = 0;
        for(Integer n : map.get(node)){
            if(build(n, d+1)){
                c_all += children_all[n]+1;
            }
        }
        children_all[node] = c_all;
        return true;
    }
    static void checkAndDeleted(int node){
        ArrayList<Integer> nodes_temp = new ArrayList<Integer>();
        for(Integer n : map.get(node)){
            if(depth[n] == depth[node]+1){
                nodes_temp.add(n);
                checkAndDeleted(n);
            }
        }
        if(nodes_temp.size() == 0)
            return;
        if(nodes_temp.size() == 1){
            currentDeleted += children_all[nodes_temp.get(0)]+1;
            children_all[node] = 0;
            return;
        }
        int n1 = nodes_temp.get(0), n2 = nodes_temp.get(1);
        int sum = children_all[n1]+children_all[n2]+2;
        if(children_all[n1] < children_all[n2]){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        for(int i = 2; i < nodes_temp.size(); i++){
            int c = nodes_temp.get(i);
            sum += children_all[c]+1;
            if(children_all[c] > children_all[n1]){
                n2 = n1;
                n1 = c;
            }
            else if(children_all[c] > children_all[n2]){
                n2 = c;
            }
        }
        children_all[node] = children_all[n1]+children_all[n2]+2;
        currentDeleted += sum - children_all[node];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1a/B-large-practice.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/round1a/B-large-practice.out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            System.out.println(_t);
            temp = reader.readLine();
            N = Integer.parseInt(temp);

            depth = new int[N];
            children_all = new int[N];
            map = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < N; i++)
                map.add(new ArrayList<Integer>());
            for(int i = 0; i < N-1; i++){
                temp = reader.readLine();
                String []temp2 = temp.split(" ");
                int x = Integer.parseInt(temp2[0])-1;
                int y = Integer.parseInt(temp2[1])-1;

                map.get(x).add(y);
                map.get(y).add(x);
            }
            deleted = N+1;
            if(N == 0 || N == 1){
                deleted = 0;
            }
            else if(N == 2){
                deleted = 1;
            }
            else{
            for(int root = 0; root < N; root++){
                //if(degrees[root] != 2)
                //    continue;

                Arrays.fill(depth, -1);
                Arrays.fill(children_all, 0);
                build(root, 0);

                currentDeleted = 0;
                checkAndDeleted(root);
                if(currentDeleted < deleted)
                    deleted = currentDeleted;
            }
            }
            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write(""+deleted);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
