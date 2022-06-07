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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        //length
        ListNode first = head;
        ListNode a = head;
        int l = 1;
        while(a.next != null) {
            a = a.next;
            l++;
        }
        
        k = k % l;
        if (k == 0)
            return head;
        
        ListNode last = a;
        a = head;
        int p = 0;
        
        while (p != l - k - 1) {
            a = a.next;
            p++;
        }
        
        head = a.next;
        a.next = null;
        last.next = first;
        
        return head;
        
    }
}