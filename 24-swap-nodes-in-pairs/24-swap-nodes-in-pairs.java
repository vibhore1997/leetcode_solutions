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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummy = head.next;
        ListNode a = head;
        
        ListNode prev = null;
        
        while (a != null && a.next != null) {
            ListNode b = a.next;
            ListNode c = a.next.next;
            b.next = a;
            a.next = c;
            
            if (prev != null) prev.next = b;
            
            prev = a;
            a = c;
        }
        return dummy;
    }
}