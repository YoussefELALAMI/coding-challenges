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
    public void flatten(TreeNode root) {
        getTail(root);
    }

    private TreeNode getTail(TreeNode node){
        if(node == null) return null;

        TreeNode leftTail = getTail(node.left);
        TreeNode rightTail = getTail(node.right);

        if(leftTail == null){
            return rightTail != null ? rightTail : node;
        }

        TreeNode oldRight = node.right;

        node.right = node.left;
        node.left = null;

        leftTail.right = oldRight;

        return rightTail != null ? rightTail : leftTail;
    }
}