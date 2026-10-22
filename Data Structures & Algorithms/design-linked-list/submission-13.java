class MyLinkedList {
    DLLNode head = null;
    DLLNode tail = null;

    public void printLL(DLLNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        DLLNode cur = head;
        System.out.print("[");
        while (cur.next != null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println(cur.val + "]");
    }

    public MyLinkedList() {}

    public int get(int index) {
        DLLNode cur = head;
        System.out.print("get at index " + index + ": ");
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                System.out.println(" -1 inner");
                return -1;
            }
            cur = cur.next;
        }
        int val = (cur == null) ? -1 : cur.val;
        System.out.println(val);
        return val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new DLLNode(val);
            tail = head;
            System.out.print("addAtHead " + val + ":");
            printLL(head);
            return;
        }
        head.prev = new DLLNode(val, null, head);
        head = head.prev;
        //System.out.print("addAtHead " + val + ":");
        //printLL(head);
    }

    public void addAtTail(int val) {
        tail.next = new DLLNode(val, tail, null);
        tail = tail.next;
        System.out.print("addAtTail " + val + ":");
        printLL(head);
    }

    public void addAtIndex(int index, int val) {
        DLLNode cur = head;
        DLLNode prev = null;
        for (int i = 0; i < index; i++) {
            prev = cur;
            if (cur == null) return;
            cur = cur.next;
        }
        if (cur == null) {
            tail = new DLLNode(val,prev,null);
            tail.prev.next = tail;
        }
        else {
            DLLNode nw = new DLLNode(val, cur.prev, cur);
            cur.prev.next = nw;
            cur.prev = nw;
        }
        System.out.print("add " + val + " AtIndex " + index + ":");
        printLL(head);
    }

    public void deleteAtIndex(int index) {
        DLLNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null) return;
            cur = cur.next;
        }
        if (cur == null) return;
        if (cur.prev != null)
            cur.prev.next = cur.next;
        else head = null;
        if (cur.next != null)
            cur.next.prev = cur.prev;
        else tail = cur.prev;
        cur.prev = null;
        cur.next = null;
        System.out.print("deleteAtIndex " + index + ":");
        printLL(head);
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