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
    public void printLL(ListNode cur) {
        if (cur == null) return;
        System.out.print("[");
        while (cur.next != null) {
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
        System.out.println(cur.val + "]");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode prev1 = null;
        ListNode prev2 = null;
        ListNode first = null;

        if (cur1 == null) return cur2;
        if (cur2 == null) return cur1;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                if (first == null)
                    first = cur1;
                if (prev2 != null) {
                    prev2.next = cur1;
                    ListNode tmp1 = cur1.next;
                    if (cur2 == cur1) break;
                    cur1.next = cur2;
                    prev2 = cur1;
                    cur1 = tmp1;
                } else {
                    if (cur1.next == null) {
                        prev2 = cur1;
                        cur1.next = cur2;
                    }
                    prev1 = cur1;
                    cur1 = cur1.next;
                }
            } else {
                if (first == null)
                    first = cur2;
                if (prev1 != null) {
                    prev1.next = cur2;
                    ListNode tmp2 = cur2.next;
                    if (cur2 == cur1) break;
                    cur2.next = cur1;
                    prev1 = cur2;
                    cur2 = tmp2;
                } else {
                    if (cur2.next == null) {
                        prev1 = cur2;
                        cur2.next = cur1;
                    }
                    prev2 = cur2;
                    cur2 = cur2.next;
                }
            }
        }
        

        return first;
    }
}