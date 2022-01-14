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

            for(int i=0; i<lists.length; i++) {
              if (lists[i] != null) {
                heap.offer(lists[i]);
              }
            }
                
            while (heap.size() != 0) {
              ListNode node = heap.poll();
              res.next = node;
              res = res.next;
                
              node = node.next;
                
                if (node != null) {
                     heap.offer(node);
                } 
            }
        
        res.next = null;
                
        return head.next;
    }
}