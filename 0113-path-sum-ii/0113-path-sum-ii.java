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
    List<List<Integer>> paths;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<>();
        if(root == null) return paths;
        Deque<Integer> currPath = new ArrayDeque<>();

        helper(root, targetSum, currPath);

        return paths; 
    }

    private void helper(TreeNode node, int targetSum, Deque<Integer> currPath){
        if(node == null) return;
        currPath.addLast(node.val);
        targetSum -= node.val;
        if(node.left == null && node.right == null && targetSum == 0){
            paths.add(new ArrayList<>(currPath));
        } else {
            helper(node.left, targetSum, currPath);
            helper(node.right, targetSum, currPath);
        }
        currPath.removeLast();
    }
}