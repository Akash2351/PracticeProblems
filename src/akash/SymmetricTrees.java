package akash;

/**
 * Created by akash on 16-10-2017.
 */
public class SymmetricTrees {

            /* 1
              / \
              2   2
              / \ / \
              3  4 4  3    is symmetric

    1
   / \
  2   2
   \   \
   3    3  is not symmetric

   To check if two trees are symmetric:
   1) if two trees are null - > sym
            OR
    1) values should be same
    2) t1. left child ==  t2. right child
    3) t1.right child == t2. left child
            then sym... else false
              */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return checkIfSym(root.left, root.right);
    }

    boolean checkIfSym(TreeNode t1, TreeNode t2) {

        //if both tree nodes are null..i.e same, trees are symmetric
        if (t1 == null && t2 == null)
            return true;
        //only one of the tree nodes are null..therefore not sym trees
        if (t1 == null || t2 == null)
            return false;

        // if node values are same, t1.left tree == t2.right, t1.right==t2.left => then sym
        if (t1.val == t2.val) {
            if (checkIfSym(t1.left, t2.right) && checkIfSym(t1.right, t2.left))
                return true;
        }
        return false;
    }
}
