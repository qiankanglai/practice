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
    public void go(TreeNode node, TreeNode smallest, TreeNode biggest)
    {
        if(node == null)
            return;
        if(smallest != null && node.val <smallest.val){
            temp.add(node); temp.add(smallest);
        }
        if(biggest != null && node.val >biggest.val){
            temp.add(node); temp.add(biggest);
        }

        go(node.left, smallest, node);
        go(node.right, node, biggest);
    }
    ArrayList<TreeNode> temp;
    public void recoverTree(TreeNode root) {
        temp = new ArrayList<TreeNode>();
        go(root, null, null);
        if(temp.size() == 2){
            swap(temp.get(0), temp.get(1));
        }
        else if(temp.size() == 4){
            swap(temp.get(0), temp.get(2));
        }
    }

    public static void main(String args[]){
        TreeNode n1 = new TreeNode(1),n2=new TreeNode(2),n3 = new TreeNode(3);
        n2.left = n3;n2.right = n1;
        new RecoverBinarySearchTree().recoverTree(n2);;
    }
}
