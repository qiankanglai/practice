package hihocoder;

import java.util.*;

/**
 * Created by Anthony on 2016/7/17.
 */
public class test3_try {
    static class store{
        public ArrayList<Integer> childs = new ArrayList<Integer>();
        public int parentCount = 0;
        public boolean stable = false;
        public ArrayList<Integer> path = null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        store graph[] = new store[n+1];
        for(int i = 0; i <= n; i++) graph[i] = new store();
        for(int i = 1; i <= n; i++)
        {
            graph[i].parentCount = in.nextInt();
            for(int j = 0; j < graph[i].parentCount; j++)
            {
                int k = in.nextInt();
                graph[k].childs.add(i);
            }
        }

        graph[0].path = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<Integer>();
        temp.add(0);
        boolean flag = false;
        while(!temp.isEmpty()){
            int idx = temp.pop();
            store node = graph[idx];
            for(int childIdx:node.childs)
            {
                if(graph[childIdx].path == null)
                {
                    graph[childIdx].path = new ArrayList<>(node.path);
                    graph[childIdx].path.add(idx);
                }
                else if(!graph[childIdx].stable)
                {
                    boolean duplicate = false;
                    for(int p : graph[childIdx].path)
                    {
                        if(node.path.contains(p))
                        {
                            duplicate = true;
                            break;
                        }
                    }
                    if(!duplicate)
                        graph[childIdx].stable = true;
                }
                store node2 = graph[childIdx];
                node2.parentCount--;
                if(node2.parentCount==0)
                {
                    temp.add(childIdx);
                }
            }
        }

        int sum = 0;
        for(int i = 1;i <= n; i++)
        {
            if(graph[0].childs.contains(i)) continue;
            if(!graph[i].stable) sum++;
        }
        System.out.println(n-sum);
    }
}
