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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> level = new ArrayDeque<>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(leftToRight){
                    level.addLast(current.val);
                } else {
                    level.addFirst(current.val);
                }
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            leftToRight = !leftToRight;
            results.add(new ArrayList<>(level));
        }

        return results;
    }
}