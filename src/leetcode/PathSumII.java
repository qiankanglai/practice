package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Anthony on 2014/5/16.
 */
public class PathSumII {
    ArrayList<ArrayList<Integer>> result = null;
    public void go(TreeNode node, int sum, Stack<Integer> path){
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == node.val)
                result.add(new ArrayList<Integer>(Arrays.asList(path.toArray(new Integer[0]))));
        }
        else{
            if(node.left != null)
                go(node.left, sum-node.val, path);
            if(node.right != null)
                go(node.right, sum-node.val, path);
        }
        path.pop();
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        go(root, sum, new Stack<Integer>());
        return result;
    }
}
