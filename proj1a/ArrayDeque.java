public class ArrayDeque <T>{
    private T[] items;
    private int size;
    private double usageRatio;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;

    }
    private void biggerResize(int n){
        T[] a = (T[]) new Object[n];
        T[] copy = items;
        int last = minusOne(nextLast);
        int first = plusOne(nextFiirst);

    }

}
