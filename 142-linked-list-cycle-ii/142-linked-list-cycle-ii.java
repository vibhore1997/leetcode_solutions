/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode inter = null;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                inter = slow;
                break;
            }
        }
        
        if (inter == null) {
            return null;
        }
        
        ListNode p1 = head;
        
        while (p1 != inter) {
            p1 = p1.next;
            inter = inter.next;
        }
        return inter;
    }
}