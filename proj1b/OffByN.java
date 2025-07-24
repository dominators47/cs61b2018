public class OffByN implements CharacterComparator {
    private int dif;

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == dif;
    }

    public OffByN(int N) {
        dif = N;
    }
}
