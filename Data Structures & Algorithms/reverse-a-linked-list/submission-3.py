# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        self.prev = None
        self.cur = head

        while self.cur != None:
            tmp = self.cur.next
            self.cur.next = self.prev
            self.prev = self.cur
            self.cur = tmp
        
        return self.prev

        