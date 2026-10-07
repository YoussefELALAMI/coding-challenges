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
    int good = 0;
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        if(node.val >= maxSoFar){
            good++;
            maxSoFar = node.val;
        }
        dfs(node.left, maxSoFar);
        dfs(node.right, maxSoFar);
        return good;
    }
}


/** Brute Force idea:
 for every node X:
    find the path from the root to X
    determine the max on this path
    check if X is greater than the max

 Time complexity is O(n²)
 Space complexity is O(n)
 */

 /**
    Optimize : During DFS, pass the maximum value seen on the path
    Recursive func dfs : 
        params : node TreeNode , maxSoFar int
        base case : if node is null then we return 0
        if node.val is greater or equals maxSoFar, then good++
        dfs(node.left, maxSoFar)
        dfs(node.right, maxSoFar)
        return good
  */