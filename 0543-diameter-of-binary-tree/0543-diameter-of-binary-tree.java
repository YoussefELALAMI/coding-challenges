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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        int result = longestPathDFS(root);
        return Math.max(result, this.diameter);
    }

    private int longestPathDFS(TreeNode node) {
        if(node == null) return -1;
        int left = longestPathDFS(node.left);
        int right = longestPathDFS(node.right);
        this.diameter = Math.max(this.diameter, left + right + 2);
        return 1 + Math.max(left, right);
    }
}