/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Iterative Approach : Two Pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        
        for(int i = 0; i <= n; i++){
            if(right == null) return null;
            right = right.next;
        }

        while(right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}


/**
 Recursive Approach :
 Time Complexity : O(N)
 Space Complexity : O(N)
 class Solution {
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return nthToLast(head, n);

    }

    private ListNode nthToLast(ListNode head, int n){
        if(head == null) return null;

        head.next = nthToLast(head.next, n);
        count++;
        if(count == n){
            return head.next;
        }
        return head;
    }
}
 */