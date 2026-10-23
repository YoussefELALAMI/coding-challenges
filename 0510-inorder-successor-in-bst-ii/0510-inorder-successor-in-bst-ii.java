/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right != null){
            node = node.right;
            while(node.left != null) node = node.left;
            return node;
        }

        while(node.parent != null && node == node.parent.right) node = node.parent;
        return node.parent;
    }
}

/**
# LC510 · Inorder Successor in BST II · Medium

1. Understand
   Given a node in a binary search tree, return the in-order successor of that node in the BST.
   Inputs (size n, value range, sorted? duplicates? empty?):
            -> Node node : -105 <= Node.val <= 105 ; Node or Null
   Output (index or value? any order?):
            -> Node successor : Node or Null
   Assumptions I said out loud:
            -> 

2. Examples
   Normal:  tree = [2,1,3], node = 1 → 2
   Edge:    tree = [5,3,6,2,4,null,null,1], node = 6 → null
   Tricky:  tree = [10,5,20,null,null,15,null,12], node = 10 → 12

3. Brute force
   Idea: if the parent's node is greater than the node we return the parent, if not we go to the right of the node and we get the most left in the right tree's node.                             
   Time O(N)   Space O(H)

4. Optimize
 */