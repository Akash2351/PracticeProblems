package akash;

/**
 * Created by akash on 16-10-2017.
 */
public class BalancedTree {

    //http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-balanced
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {

            return checkIfBalanced(root) == -1 ? false : true;

        }

        int checkIfBalanced(TreeNode root) {
            if (root == null)
                return 0;

            int leftHeight = checkIfBalanced(root.left);
            if (leftHeight == -1) return -1;

            int rightHeight = checkIfBalanced(root.right);
            if (rightHeight == -1) return -1;

            if ((int) Math.abs(leftHeight - rightHeight) > 1)
                return -1;

            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
}
