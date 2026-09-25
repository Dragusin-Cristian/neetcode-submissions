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
    public int maxDepth(TreeNode root) {
        // edge case: tree is empty
        if (root == null) return 0;

        // we are at the bottom:
        if (root.left == null && root.right == null) {
            return 1;
        }

        // recursively get the maxD of left and right
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right); 

        // compare and return the max + 1
        return Math.max(lDepth, rDepth) + 1;
    }
}
