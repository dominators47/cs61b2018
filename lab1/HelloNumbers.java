public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int y = 1;
        while (x < 50) {
            System.out.print(x + " ");
            x = x + y;
            y = y + 1;
        }
    }
}