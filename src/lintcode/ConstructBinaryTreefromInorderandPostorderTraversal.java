package lintcode;

import java.util.Arrays;

/**
 * Created by anthony on 6/29/14.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length != inorder.length)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int idx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[postorder.length-1]){
                idx = i;
                break;
            }
        }
        if(idx < 0){
            return null;
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, idx), Arrays.copyOfRange(postorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(inorder, idx + 1, inorder.length), Arrays.copyOfRange(postorder, idx, postorder.length - 1));
        return root;
    }

    public static void main(String args[]){
        new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(
                new int[]{4,15,5,3,7,6,8,10,9,11},
                new int[]{15,5,4,7,10,11,9,8,6,3}
        );
    }
}
