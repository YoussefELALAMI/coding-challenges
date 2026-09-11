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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Deque<TreeNode> tree = new ArrayDeque<>();
        if(root == null) return output;
        tree.push(root);
        while(!tree.isEmpty()){
            TreeNode curr = tree.pop();
            output.add(curr.val);
            if(curr.right != null) tree.push(curr.right);
            if(curr.left != null) tree.push(curr.left);
        }
        return output;
    }
}



/**
    Recursive Approach :
        class Solution {
            List<Integer> output = new ArrayList<>();
            public List<Integer> preorderTraversal(TreeNode root) {
                if(root == null) return output;
                this.output.add(root.val);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
                return output;
            }
        }
 */