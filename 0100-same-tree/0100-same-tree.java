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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        if(p == null && q == null) return true;
        else if((p == null && q != null) 
                || (q == null && p != null)){
                    return false;
        }
        else if(p.val != q.val) return false;
        result = result && isSameTree(p.left, q.left);
        result = result && isSameTree(p.right, q.right);
        return result;
    }
    private boolean checkNodes(TreeNode p, TreeNode q){
        boolean result = true;
        if(p == null && q == null) return true;
        else if((p == null && q != null) 
                || (q == null && p != null)){
                    return false;
        }
        else if(p.val != q.val) return false;
        result = result && checkNodes(p.left, q.left);
        result = result && checkNodes(p.right, q.right);
        return result;
    }
}