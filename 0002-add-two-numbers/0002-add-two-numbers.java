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

/**
 * Recursive technique
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return addTwoNumRecursive(l1, l2, carry);
    }

    private ListNode addTwoNumRecursive(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry ==0) return null;
        ListNode node = new ListNode(0);
        int value = carry;
        if(l1 != null) value += l1.val;
        if(l2 != null) value += l2.val;
        node.val = value % 10;
        if (l1 != null || l2 != null) {
            node.next = addTwoNumRecursive(l1 == null ? null : l1.next,
                                        l2 == null ? null : l2.next,
                                        value >= 10 ? 1 : 0);
        }
        return node;
    }
}

/**
 * A single-pass traversal with a dummy head node technique
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode beforehead = new ListNode(0);
        ListNode node = beforehead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum/10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return beforehead.next;
    }
}
 */