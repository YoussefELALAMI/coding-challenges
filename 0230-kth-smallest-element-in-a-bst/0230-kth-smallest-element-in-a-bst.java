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
    List<Integer> values;
    public int kthSmallest(TreeNode root, int k) {
        values = new ArrayList<>();
        inOrder(root);
        return values.get(k-1);
    }

    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        values.add(node.val);
        inOrder(node.right);
    }
}