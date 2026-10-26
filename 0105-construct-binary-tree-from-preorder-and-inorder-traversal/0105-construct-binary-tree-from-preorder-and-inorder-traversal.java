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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) return null;

        TreeNode root = new TreeNode(preorder[0]);

        if (preorder.length == 1) return root;

        int position = getSize(inorder, root.val);

        int[] leftPreOrderArray =  Arrays.copyOfRange(preorder, 1, position+1);
        int[] rightPreOrderArray = Arrays.copyOfRange(preorder, position+1, preorder.length);
        
        int[] leftInOrderArray = Arrays.copyOfRange(inorder, 0, position);
        int[] rightInOrderArray = Arrays.copyOfRange(inorder, position+1, inorder.length);

        root.left = buildTree(leftPreOrderArray, leftInOrderArray);
        root.right = buildTree(rightPreOrderArray, rightInOrderArray);

        return root;
    }

    private int getSize(int[] subArray, int target){
        int index = -1;
        for (int i = 0; i < subArray.length; i++) {
            if (subArray[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }
}