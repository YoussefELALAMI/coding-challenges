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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> solution = new ArrayList<>();
        getPath(root, "", solution);
        return solution;
    }

    private void getPath(TreeNode node, String path, List<String> solution ) {
        if (node != null){
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) solution.add(path);
            else {
                path += "->";
                getPath(node.left, path, solution);
                getPath(node.right, path, solution);
            }
        }
    }
}