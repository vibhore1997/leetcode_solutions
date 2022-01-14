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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        boolean found = true;
        ListNode head = new ListNode();
        ListNode res = head;
        
        while (found) {
            found = false;
            for(int i=0; i<lists.length; i++) {
                
              if (lists[i] != null) {
                found = true;
                heap.offer(lists[i]);
                lists[i] = lists[i].next;
              }
                
          }
            
            if (found) {
                res.next = heap.poll();
               res = res.next;
            }
        }
        
        while (heap.size() != 0) {
            res.next = heap.poll();
            res = res.next;
        }
        res.next = null;
        return head.next;
    }
}