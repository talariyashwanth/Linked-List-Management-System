public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    public boolean isEmpty() { return head == null; }

    public void insertAtBeginning(int data) {
        Node node = new Node(data);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public boolean insertAtPosition(int data, int position) {
        if (position < 1) return false;
        if (position == 1) { insertAtBeginning(data); return true; }
        Node current = head;
        for (int i = 1; current != null && i < position; i++) current = current.next;
        if (current == null) {
            if (position == count() + 1) { insertAtEnd(data); return true; }
            return false;
        }
        Node node = new Node(data);
        Node before = current.prev;
        node.prev = before;
        node.next = current;
        before.next = node;
        current.prev = node;
        return true;
    }

    public boolean insertAfterValue(int target, int data) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        if (current == tail) { insertAtEnd(data); return true; }
        Node node = new Node(data);
        node.prev = current;
        node.next = current.next;
        current.next.prev = node;
        current.next = node;
        return true;
    }

    public boolean insertBeforeValue(int target, int data) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        if (current == head) { insertAtBeginning(data); return true; }
        Node node = new Node(data);
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        current.prev = node;
        return true;
    }

    public boolean deleteFromBeginning() {
        if (head == null) return false;
        if (head == tail) head = tail = null;
        else { head = head.next; head.prev = null; }
        return true;
    }

    public boolean deleteFromEnd() {
        if (tail == null) return false;
        if (head == tail) head = tail = null;
        else { tail = tail.prev; tail.next = null; }
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1) return false;
        Node current = head;
        for (int i = 1; current != null && i < position; i++) current = current.next;
        if (current == null) return false;
        unlink(current);
        return true;
    }

    public boolean deleteByValue(int value) {
        Node current = head;
        while (current != null && current.data != value) current = current.next;
        if (current == null) return false;
        unlink(current);
        return true;
    }

    private void unlink(Node node) {
        if (node == head) { deleteFromBeginning(); return; }
        if (node == tail) { deleteFromEnd(); return; }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int search(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) return position;
            current = current.next;
            position++;
        }
        return -1;
    }

    public boolean update(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) { current.data = newValue; return true; }
            current = current.next;
        }
        return false;
    }

    public void displayForward() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node current = head;
        System.out.print("NULL <- ");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            System.out.print(current == null ? " -> NULL" : " <-> ");
        }
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) { System.out.println("List is empty."); return; }
        Node current = tail;
        System.out.print("NULL <- ");
        while (current != null) {
            System.out.print(current.data);
            current = current.prev;
            System.out.print(current == null ? " -> NULL" : " <-> ");
        }
        System.out.println();
    }

    public int count() {
        int count = 0;
        for (Node current = head; current != null; current = current.next) count++;
        return count;
    }

    public Integer maximum() {
        if (head == null) return null;
        int max = head.data;
        for (Node current = head.next; current != null; current = current.next)
            if (current.data > max) max = current.data;
        return max;
    }

    public Integer minimum() {
        if (head == null) return null;
        int min = head.data;
        for (Node current = head.next; current != null; current = current.next)
            if (current.data < min) min = current.data;
        return min;
    }

    public Integer middle() {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data; // For even length, returns the second middle.
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node oldNext = current.next;
            current.next = current.prev;
            current.prev = oldNext;
            current = oldNext;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void sort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        for (Node current = head; current != null; current = current.next) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    Node duplicate = runner.next;
                    runner.next = duplicate.next;
                    if (duplicate.next != null) duplicate.next.prev = runner;
                    else tail = runner;
                } else runner = runner.next;
            }
        }
    }
}
