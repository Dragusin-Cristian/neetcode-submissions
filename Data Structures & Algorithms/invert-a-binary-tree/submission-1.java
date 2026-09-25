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
    public TreeNode invertTree(TreeNode root) {
        // edge cases: empty tree | tree with 1 node
        // and stop when there is no left and right
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        };

        // invert left with right
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // call recursive on children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
