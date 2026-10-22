class MyLinkedList {
    DLLNode head = null;
    DLLNode tail = null;

    public MyLinkedList() {}

    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        DLLNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return -1;
            }
            cur = cur.next;
        }
        return (cur == null) ? -1 : cur.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new DLLNode(val);
            tail = head;
            return;
        }
        head.prev = new DLLNode(val, null, head);
        head = head.prev;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            head = tail = new DLLNode(val);
            return;
        }
        tail.next = new DLLNode(val, tail, null);
        tail = tail.next;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        DLLNode cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null)
                return;
            cur = cur.next;
        }

        if (cur == null) {
            addAtTail(val);
            return;
        }

        DLLNode node = new DLLNode(val, cur.prev, cur);
        cur.prev.next = node;
        cur.prev = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0)
            return;

        DLLNode cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null)
                return;
            cur = cur.next;
        }

        if (cur == null)
            return;

        if (cur.prev != null) {
            cur.prev.next = cur.next;
        } else {
            head = cur.next;
        }

        if (cur.next != null) {
            cur.next.prev = cur.prev;
        } else {
            tail = cur.prev;
        }

        cur.prev = null;
        cur.next = null;
    }
}

class DLLNode {
    int val;
    DLLNode next = null;
    DLLNode prev = null;

    public DLLNode() {}

    public DLLNode(int val) {
        this.val = val;
    }

    public DLLNode(int val, DLLNode prev, DLLNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */