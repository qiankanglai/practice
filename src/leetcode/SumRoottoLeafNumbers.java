package leetcode;

/**
 * Created by anthony on 5/16/14.
 */
public class SumRoottoLeafNumbers {
    int sum;
    public void go(TreeNode node, int current){
        if(node == null) return;
        current = current*10+node.val;
        if(node.right==null&&node.left==null)
            sum += current;
        else
        {
            go(node.left, current);
            go(node.right, current);
        }
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        go(root, 0);
        return sum;
    }
}
