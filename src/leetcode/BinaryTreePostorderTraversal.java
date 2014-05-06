package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Anthony on 2014/5/6.
 */
public class BinaryTreePostorderTraversal {
    class TreeNodeStatus{
        TreeNode node;
        int status;
        TreeNodeStatus(TreeNode node, int status){
            this.node = node;
            this.status = status;
        }
    }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNodeStatus> stack = new Stack<TreeNodeStatus>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        stack.push(new TreeNodeStatus(root, 0));
        while(!stack.empty()){
            TreeNodeStatus nodestatus = stack.peek();
            if(nodestatus.status < 1 && nodestatus.node.left != null){
                nodestatus.status=1;
                stack.push(new TreeNodeStatus(nodestatus.node.left, 0));
                continue;
            }
            if(nodestatus.status < 2 && nodestatus.node.right != null){
                nodestatus.status=2;
                stack.push(new TreeNodeStatus(nodestatus.node.right, 0));
                continue;
            }
            res.add(nodestatus.node.val);
            stack.pop();
        }
        return res;
    }
}
