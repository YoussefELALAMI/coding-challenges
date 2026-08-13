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
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, next = null;
        
        while(curr != null){
            ListNode dummy = new ListNode(curr.val);
            next = curr.next;
            dummy.next = prev;
            prev = dummy;
            curr = next;
        }

        while (head != null) {
            if(head.val != prev.val) return false;
            prev = prev.next;
            head = head.next;
        }

        return true;
    }
}