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

        ListNode fast = head;
        ListNode slow = head;

        Stack<Integer> values = new Stack<>();

        while(fast != null && fast.next != null){
            values.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int v = values.pop(); 
            if(slow.val != v) return false;
            slow = slow.next;
        }

        return true;
    }
}


/**
  -  Reverse linked list solution
  -  Time complexity is : O(n)
  -  Space Complexity is  : O(n)
  Suggestions:
        Reverse the second half of the list in place using three pointers to achieve constant space complexity without creating new nodes.


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
 */