/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        // edge cases: empty tree, or tree of one
        if (root == null || (root.left == null && root.right == null)) return true;

        this.checkDepth(root);
  
        return res;
    }

    int checkDepth(TreeNode root) {
        // compare the depth of left and right, check if diff > 1 
        // (return false if so)
        int depthL = root.left == null ? 0 : checkDepth(root.left);
        int depthR = root.right == null ? 0 : checkDepth(root.right);

        if (Math.abs(depthL - depthR) > 1) {
            res = false;
        }

        // else return 1 + Max of depth left and right
        return Math.max(depthL, depthR) + 1;
    }
}
