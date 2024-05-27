package task3;

public class Pair {
    final String word;
    final int count;

    public Pair(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public static int compare(Pair first, Pair second) {
        int result = Integer.compare(first.count, second.count);
        return -result;
    }
}
