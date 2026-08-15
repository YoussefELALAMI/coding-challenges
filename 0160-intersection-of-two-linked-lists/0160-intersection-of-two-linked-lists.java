/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = count(headA) - count(headB);
        if (diff > 0) {
            for(int i = 0; i < diff; i++) headA = headA.next;
        } else if (diff < 0){
            for(int i = Math.abs(diff); i > 0; i--) headB = headB.next;
        } 
        while (headA != null && headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int count(ListNode node){
        if(node == null) return 0;
        return 1 + count(node.next);
    }
}



/**
 * HashTable solution :
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodes.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
 */