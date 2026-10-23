class MyLinkedList:

    class Node:

        def __init__(self,*args):
            if len(args) <= 1:
                self.prev = None
                self.next = None
            if len(args) == 1:
                self.val = args[0]
            elif len(args) == 3:
                self.val = args[0]
                self.prev = args[1]
                self.next = args[2]


    def __init__(self):
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0

    def getNode(self, index: int):
        if index < 0 or index >= self.size or self.head.next == self.tail:
            return None
        if index < self.size/2:
            cur = self.head.next
            for i in range(index):
                cur = cur.next
        else:
            cur = self.tail.prev
            for i in range(self.size - index - 1):
                cur = cur.prev
        return cur


    def get(self, index: int) -> int:
        node = self.getNode(index)
        return node.val if node else -1
        

    def addAtHead(self, val: int) -> None:
        if self.head.next == self.tail:
            self.head.next = self.Node(val,self.head,self.tail)
            self.tail.prev = self.head.next
        else:
            tmp = self.head.next
            self.head.next = self.Node(val,self.head,tmp)
            tmp.prev = self.head.next
        self.size += 1
        

    def addAtTail(self, val: int) -> None:
        if self.tail.prev == self.head:
            self.tail.prev = self.Node(val,self.head,self.tail)
            self.head.next = self.tail.prev
        else:
            tmp = self.tail.prev
            self.tail.prev = self.Node(val,tmp,self.tail)
            tmp.next = self.tail.prev
        self.size += 1
        

    def addAtIndex(self, index: int, val: int) -> None:
        if index == self.size:
            self.addAtTail(val)
        else:
            node = self.getNode(index)
            if node:
                tmp = node.prev
                node.prev = self.Node(val,tmp,node)
                tmp.next = node.prev
                self.size += 1
        

    def deleteAtIndex(self, index: int) -> None:
        node = self.getNode(index)
        if node:
            node.next.prev = node.prev
            node.prev.next = node.next
            node.next = None
            node.prev = None
            self.size -= 1
            
        


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)