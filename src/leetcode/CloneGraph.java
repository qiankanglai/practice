package leetcode;

import java.util.HashMap;

/**
 * Created by anthony on 6/10/14.
 */
public class CloneGraph {
    public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if(node == null)
            return null;
        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        map.put(node.label, newnode);
        for(UndirectedGraphNode n : node.neighbors){
            newnode.neighbors.add(dfs(n, map));
        }
        return newnode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        if(node == null)
            return null;
        return dfs(node, map);
    }
}
