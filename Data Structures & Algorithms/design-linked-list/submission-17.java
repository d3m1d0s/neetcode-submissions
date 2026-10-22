public class MyLinkedList {
    private DLLNode head;
    private DLLNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private DLLNode getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index <= size / 2) {
            DLLNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            DLLNode cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    public int get(int index) {
        DLLNode node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        DLLNode node = new DLLNode(val);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        DLLNode node = new DLLNode(val);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        DLLNode next = getNode(index);
        DLLNode prev = next.prev;
        DLLNode nw = new DLLNode(val);

        nw.prev = prev;
        nw.next = next;

        prev.next = nw;
        next.prev = nw;

        size++;
    }

    public void deleteAtIndex(int index) {
        DLLNode node = getNode(index);

        if (node == null) return;

        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
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