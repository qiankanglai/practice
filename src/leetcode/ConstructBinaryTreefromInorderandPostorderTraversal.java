package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 6/9/14.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null)
            return null;
        if(postorder.length == 0 || inorder.length == 0)
            return null;
        if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }
        else{
            int t = postorder[postorder.length-1];
            TreeNode root = new TreeNode(t);
            int k = 0;
            while(inorder[k] != t)
                k++;

            root.left = buildTree(Arrays.copyOfRange(inorder, 0, k),
                    Arrays.copyOfRange(postorder, 0, k));
            root.right = buildTree(Arrays.copyOfRange(inorder, k+1, inorder.length),
                    Arrays.copyOfRange(postorder, k, postorder.length-1));
            return root;
        }
    }
}
