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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right != null) {
                root.val = findSuccessor(root.right);
                root.right = deleteNode(root.right, root.val);
            } else if (root.left != null){
                root.val = findPredecessor(root.left);
                root.left = deleteNode(root.left, root.val);
            } else root = null;
        }
        return root;
    }
    private int findSuccessor(TreeNode node){
        while (node.left != null) node = node.left;
        return node.val;
    }
    private int findPredecessor(TreeNode node){
        while (node.right != null) node = node.right;
        return node.val;
    }
}