import java.util.LinkedList;

public class Queue<L> {
    private LinkedList<L> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(L e) {
        list.addLast(e);
    }

    public L dequeue() {
        if (isEmpty()) return null;
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public L peek() {
        if (isEmpty()) return null;
        return list.getFirst();
    }
}