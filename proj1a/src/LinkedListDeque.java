public class LinkedListDeque<T> {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode (IntNode prev0, T item0, IntNode next0) {
            prev = prev0;
            item = item0;
            next = next0;
        }

        public  IntNode () {
//            this(null, new T() , null);
        }

    }

    public LinkedListDeque () {
        sentinel = new IntNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next.prev = new IntNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }
    public void addLast(T item) {
//        sentinel.prev.next.prev = sentinel.prev;
//        sentinel.prev.next.next = sentinel;
//        sentinel.prev.next.item = item;
        sentinel.prev.next = new IntNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        IntNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            p = p.next;
        }
        System.out.print("\n");
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            IntNode p = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return p.item;
        }
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        else {
            IntNode p = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return p.item;
        }
    }
    public T get(int index) {
        IntNode p = sentinel.next;
        for (int i=0; i < index; ++i) {
            p = p.next;
        }
        return p.item;
    }
}