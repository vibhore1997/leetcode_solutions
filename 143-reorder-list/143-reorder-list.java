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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        if(fast.next == null) {
            return;
        }
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast.next == null) {
            
        }
        else if (fast.next.next == null) fast = fast.next;
        
        ListNode prev = null;
        ListNode temp = slow;
        
        while (slow != null) {
            slow = slow.next;
            temp.next = prev;
            prev = temp;
            temp = slow;
        }
        
        ListNode back = prev;
        
        ListNode start = head;
        temp = null;
        ListNode tempBack = null;
        
        while (start != back && start.next != null) {
            temp = start.next;
            start.next = back;
            tempBack = back;
            back = back.next;
            tempBack.next = temp;
            start = temp;
        }
        
        if (start.next == null) {
            start.next = back;
            back.next = null;
        }
        
    }
}