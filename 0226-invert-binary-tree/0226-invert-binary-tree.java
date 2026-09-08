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
        treat(root);
        return root;
    }

    private TreeNode switchNodes(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    private void treat(TreeNode node){
        if(node == null) return;
        node = switchNodes(node);
        treat(node.left);
        treat(node.right);
    }
}