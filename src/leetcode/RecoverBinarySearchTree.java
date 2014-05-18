package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Anthony on 2014/5/8.
 */
public class RecoverBinarySearchTree {
    public void swap(TreeNode n1, TreeNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    public void inorderTraversal(TreeNode node)
    {
        if(node == null)
            return;
        inorderTraversal(node.left);
        temp.add(node);
        inorderTraversal(node.right);
    }
    ArrayList<TreeNode> temp;
    // I use extra space here!!!
    // Please refer to morris traversal: http://oj.leetcode.com/discuss/2103/how-can-the-space-complextity-be-better-than-log-n-with-stack
    public void recoverTree(TreeNode root) {
        temp = new ArrayList<TreeNode>();
        inorderTraversal(root);
        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
        for(int i = 0; i < temp.size(); i++){
            if(i > 0 && temp.get(i-1).val > temp.get(i).val){
                t.add(temp.get(i));
            }
            else if(i < temp.size()-1 && temp.get(i).val > temp.get(i+1).val){
                t.add(temp.get(i));
            }
        }
        swap(t.get(0), t.get(t.size()-1));
    }

    public static void main(String args[]){
        TreeNode n1 = new TreeNode(1),n2=new TreeNode(2),n3 = new TreeNode(3);
        n2.left = n3;n2.right = n1;
        new RecoverBinarySearchTree().recoverTree(n2);;
    }
}
