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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return checkHeight(root)  != -1;
    }

    private int checkHeight(TreeNode node) {    
        if(node == null) return 0;
        int hLeft = checkHeight(node.left);
        if(hLeft == -1) return -1;
        int hRight = checkHeight(node.right);
        if(hRight == -1) return -1;
        if(Math.abs(hLeft - hRight) > 1) return -1;
        return Math.max(hLeft, hRight) + 1;
    }
}