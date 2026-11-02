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
    int count = 0;
    int target;
    HashMap<Long, Integer> h = new HashMap();

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        preorder(root, 0L);
        return count;
    }

    private void preorder(TreeNode node, long prefix_sum){
        if(node == null) return;
        prefix_sum += node.val;
        if(prefix_sum == target) count++;
        count += h.getOrDefault(prefix_sum - target, 0);
        h.put(prefix_sum, h.getOrDefault(prefix_sum, 0)+1);
        preorder(node.left, prefix_sum);
        preorder(node.right, prefix_sum);
        h.put(prefix_sum, h.get(prefix_sum) - 1);
    }
}