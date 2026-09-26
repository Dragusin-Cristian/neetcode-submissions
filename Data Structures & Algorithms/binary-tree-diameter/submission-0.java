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
    int maxSumDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        // edge cases: empty tree, tree of one

        if (root == null || (root.left == null && root.right == null)) return 0;

        // compute depths
        this.computeDepth(root);
        return this.maxSumDepth;

    }

    int computeDepth(TreeNode root) {
        // get the depth of left and right, sum them and save if is max
        // if it is a leaf, will return 0

        int depthL = root.left == null ? 0 : computeDepth(root.left);
        int depthR = root.right == null ? 0 : computeDepth(root.right);

        int sumDepth = depthL + depthR;

        this.maxSumDepth = Math.max(sumDepth, this.maxSumDepth);

        // we return the max of depth between left and right

        return 1 + Math.max(depthL, depthR);
    }
}
