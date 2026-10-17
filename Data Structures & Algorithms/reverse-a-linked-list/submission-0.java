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
    public ListNode reverseList(ListNode head) {
        
        if (head == null) return head;

        ListNode cur = head;
        ListNode[] prevs = {null, null};

        while (cur.next != null) {
            prevs[0] = prevs[1];
            prevs[1] = cur;
            cur = cur.next;
            prevs[1].next = prevs[0];
        }

        cur.next = prevs[1];

        return cur;
    }
}
