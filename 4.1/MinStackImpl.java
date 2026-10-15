public class MinStackImpl implements MinStack<Integer> {
    private static class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    @Override
    public void push(Integer value) {
        int min;
        if (head == null) {
            min = value;
        } else {
            min = Math.min(value, head.min);
        }
        head = new Node(value, min, head);
    }

    @Override
    public Integer pop() {
        int elem = head.value;
        head = head.next;
        return elem;
    }

    @Override
    public Integer top() {
        return head.value;
    }

    @Override
    public Integer min() {
        return head.min;
    }
}