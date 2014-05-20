package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Anthony on 2014/5/20.
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null)
        {
            s.push(node);
            node = node.left;
        }
        while(!s.empty()){
            node = s.pop();
            result.add(node.val);
            node = node.right;
            while(node != null)
            {
                s.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
