public class LinkedListDeque<T> {

    /** invariants:
     * The sentinel reference always points to a sentinel node.
     * The first item is always at sentinel.next.item.
     * The size variable is always the total number of items that have been added.
     */
    private class IntNode{
        private IntNode prev;
        private T item;
        private  IntNode next;
        public  IntNode(){

        }
    }
}
