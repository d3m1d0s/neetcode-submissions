
public class MyLinkedList {
    private final Node head;
    private final Node tail;
    private int size;

    private static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    private Node getNode(int index) {
        if (index <= size / 2) {
            Node cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            Node cur = tail;
            for (int i = size; i > index; i--) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return getNode(index).val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index < 0)
            index = 0;

        Node next = getNode(index);
        Node prev = next.prev;
        Node node = new Node(val);

        node.prev = prev;
        node.next = next;

        prev.next = node;
        next.prev = node;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        Node node = getNode(index);

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;

        size--;
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