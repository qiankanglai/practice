package hihocoder;

import java.util.*;

/**
 * Created by Anthony on 2016/7/17.
 */
public class test3 {
    static class store{
        public ArrayList<Integer> parents = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        store graph[] = new store[n+1];
        for(int i = 0; i <= n; i++) graph[i] = new store();
        for(int i = 1; i <= n; i++)
        {
            int parentCount = in.nextInt();
            for(int j = 0; j < parentCount; j++)
            {
                graph[i].parents.add(in.nextInt());
            }
        }

        int sum = 0;
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        for(int i = 1;i <= n; i++)
        {
            if(graph[i].parents.contains(0)) continue;
            int p = graph[i].parents.get(0);
            path1.clear();
            while(p > 0)
            {
                path1.add(p);
                p = graph[p].parents.get(0);
            }
            if(!AnotherAvailablePath(graph, path1, i))
            {
                sum++;
            }
        }
        System.out.println(n-sum);
    }

    private static boolean AnotherAvailablePath(store[] graph, ArrayList<Integer> path1, int idx) {
        if(idx == 0) return true;
        store node = graph[idx];
        for(int k=0;k<node.parents.size();k++)
        {
            int p = node.parents.get(k);
            if(path1.contains(p)) continue;
            if(AnotherAvailablePath(graph, path1, p)) return true;
        }
        return false;
    }
}
