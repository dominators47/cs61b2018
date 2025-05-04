public class LinkedListDeque<T> {

    /** invariants:
     * The sentinel reference always points to a sentinel node.
     * The first item is always at sentinel.next.item.
     * The size variable is always the total number of items that have been added.
     */
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(){

        }
        public Node(Node p, T i, Node n){
            prev = p;
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private Node last;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        last = sentinel;
        size = 0;
    }

    public void addfirst(T x){
        sentinel.next = new Node(sentinel, x, sentinel.next);
        if (sentinel.next.next == sentinel){
            last = sentinel.next;
        }
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    public void addlast(T x){
        last.next = new Node(last, x, sentinel);
        last = last.next;
        sentinel.prev = last;
        size += 1;
    }
    public boolean isempty(){
        return size == 0;
    }
    public T removefirst(){
        if (isempty()){
            return null;
        }else{
            T item = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            if (sentinel.next == sentinel){
                last = sentinel;
            }
            sentinel.next.prev = sentinel;
            size -= 1;
            return item;
        }
    }

    public T removelast(){
        if(isempty()){
            return null;
        }else{
            T item =last.item;
            last = last.prev;
            last.next = sentinel;
            sentinel.prev = last;
            size -= 1;
            return item;
        }
    }

    public T get(int index){
        Node p = sentinel.next;
        whlie(index > 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }
}
