package leetcode;

import java.util.HashMap;

/**
 * Created by Anthony on 2014/5/20.
 */
public class PopulatingNextRightPointersinEachNodeII {
    HashMap<Integer, TreeLinkNode> map = null;
    public void go(TreeLinkNode node, int level){
        if(node == null)
            return;
        if(map.containsKey(level)){
            map.get(level).next = node;
        }
        map.put(level, node);
        go(node.left, level+1);
        go(node.right, level+1);
    }
    public void connect(TreeLinkNode root) {
        map = new HashMap<Integer, TreeLinkNode>();
        go(root, 0);
    }
}
