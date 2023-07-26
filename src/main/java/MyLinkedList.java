import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value, null, null);

        if (size == 0) {
            first = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        last = node;
        size++;
    }

    public void add(int index, T value) {
        Node<T> node = new Node<>(value, null, null);
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (size == 0) {
            first = node;
            last = node;
        } else if (index == 0) {
            Node<T> firstNode = first;
            firstNode.prev = node;
            node.next = firstNode;
            first = node;
        } else if (index == size) {
            Node<T> lastNode = last;
            last.next = node;
            node.prev = lastNode;
            last = node;
        } else {
            Node<T> nextNode = first;
            for (int i = 1; i <= index; i++) {
                nextNode = nextNode.next;
            }

            Node<T> prevNode = nextNode.prev;
            prevNode.next = node;
            node.prev = prevNode;
            node.next = nextNode;
            node.prev = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = first;
        while (node != null) {
            sb.append(node.value).append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    public T get(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    private class Node<T> {
        private T value;
        private Node next;
        private Node prev;

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}